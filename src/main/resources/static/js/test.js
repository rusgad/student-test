
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Vue.component('login-form', {
    data: function () {
        return {
            studentName: {
                firstName: '',
                secondName: '',
                thirdName: ''
            }
        }
    },
    methods: {
        postStudentData() {
            fetch('http://localhost:8080/api/students', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: (
                    this.studentName.firstName.trim() + ' '
                    + this.studentName.secondName.trim() + ' '
                    + this.studentName.thirdName.trim()
                )
            }).then(() => {
                this.login()
                this.studentName.firstName = ''
                this.studentName.secondName = ''
                this.studentName.thirdName = ''
            })
        },
        login() {
            this.$emit('login', this.studentName)
        }
    },
    computed: {
        validationError() {
            if ((this.studentName.firstName.trim() == '') || (this.studentName.secondName.trim() == '') ||
                (this.studentName.thirdName.trim() == '')) {
                return true
            } else {
                return false
            }
        }
    },
    template:
        '<div class="row col-md-4 mx-auto">' +
            '<input class="form-control mt-2" type="text" v-model="studentName.firstName" placeholder="Фамилия">' +
            '<input class="form-control mt-2" type="text" v-model="studentName.secondName" placeholder="Имя">' +
            '<input class="form-control mt-2" type="text" v-model="studentName.thirdName" placeholder="Отчество">' +
            '<button :disabled="validationError" class="btn btn-primary mt-2" @click="postStudentData">Сохранить</button>' +
        '</div>'
})

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Vue.component('test', {
    props: ["selectedTest", "questionsWithOptions"],
    data() {
        return {
            selectedAnswers: [],
            triggers: {
                allQuestionAnswered: true,
                showResultTrigger: false,
                testIsComplete: false
            },
            questionQuantity: 0,
            rightAnswersCount: 0
        }
    },
    methods: {
        returnBack() {
            this.$emit('return-back')
        },
        saveTestResult() {
            if (this.triggers.allQuestionAnswered == false) {
                fetch('http://localhost:8080/api/answer', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(this.questionsWithOptions)
                })
                    .then(response => response.json())
                    .then(data => this.selectedAnswers = data)
                    .then(this.showResult)
                    .then(this.countRightAnswers)
            }
        },
        checkAnswersOnNull() {
            for (let item of this.questionsWithOptions) {
                if (item.pickedAnswer.optionText == null) {
                    this.triggers.allQuestionAnswered = true
                    break
                } else {
                    this.triggers.allQuestionAnswered = false
                }
            }
        },
        showResult() {
            this.triggers.testIsComplete = true
            this.triggers.showResultTrigger = true
        },
        countRightAnswers() {
            this.questionQuantity = this.selectedAnswers.length
            for (let answer of this.selectedAnswers) {
                if (answer.selectedOption.right) {
                    this.rightAnswersCount++
                }
            }
        }
    },
    template:
        '<div class="container col-12 bg-light rounded border border-secondary mt-2 p-2">' +
            '<h1 class="text-center mb-4">{{selectedTest.title}}</h1>' +
            '<div v-for="(questionWithOptions, index) in questionsWithOptions">' +
                '<div class="m-2 p-2 rounded-3" ' +
                        ':class="{\'bg-danger text-white\': (!questionWithOptions.pickedAnswer.right &&' +
                        ' triggers.showResultTrigger), \'bg-success text-white\':' +
                        ' (questionWithOptions.pickedAnswer.right && triggers.showResultTrigger)}">' +
                    '<h4>{{index + 1}}. {{questionWithOptions.question.questionText}}</h4>' +
                    '<div  v-for="option in questionWithOptions.options">' +
                        '<div class="rounded align-items-center d-flex p-1">' +
                            '<input class="form-check-input col-1 m-1" type="radio" @change="checkAnswersOnNull" ' +
                                ':disabled="triggers.testIsComplete"' +
                                'v-bind:id="option.optionText"' +
                                'v-bind:name="questionWithOptions.question.id"' +
                                'v-bind:value="option" v-model="questionWithOptions.pickedAnswer"> ' +
                            '<label class="form-check-label col-10 m-1 fs-5" v-bind:for="option.optionText">' +
                                '{{option.optionText}}' +
                            '</label>' +
                        '</div>' +
                    '</div>' +
                '</div>' +
            '</div>' +
            '<div class="row justify-content-between m-3">' +
                '<button class="col-3 btn btn-primary" @click="returnBack">Вернуться назад</button>' +
                '<span class="col-3 text-center display-6" v-show="triggers.showResultTrigger">' +
                    '{{rightAnswersCount}}/{{questionQuantity}}' +
                '</span>' +
                '<button class="col-3 btn btn-primary" @click="saveTestResult" ' +
                    ':disabled="triggers.allQuestionAnswered || triggers.testIsComplete">Завершить тест</button>' +
           '</div>' +
        '</div>'
})

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

var app = new Vue({
    el: '#app',
    data: {
        tests: [],
        selectedTest: {},
        questionsWithOptions: [],
        latestResultOfTest: [],
        triggers: {
            loginIsDone: false,
            testIsSelected: false
        },
        studentName: {
            firstName: '',
            secondName: '',
            thirdName: ''
        }
    },
    methods: {
        fetchTests() {
            fetch('http://localhost:8080/api/test')
                .then(response => response.json())
                .then(data => this.tests = data)
        },
        selectTest(testId) {
            for (let test of this.tests) {
                if (test.id === testId) {
                    this.selectedTest = test
                }
            }
            this.fetchQuestions()
            this.changeQuestionTrigger()
        },
        fetchQuestions() {
            fetch('http://localhost:8080/api/question/' + this.selectedTest.id)
                .then(response => response.json())
                .then(data => {
                    this.questionsWithOptions = data
                    for (let item of this.questionsWithOptions) {
                        item.studentName =
                            this.studentName.firstName + ' ' +
                            this.studentName.secondName + ' ' +
                            this.studentName.thirdName
                    }
                })
                .then(this.fetchLatestResult)
        },
        changeQuestionTrigger() {
            this.triggers.testIsSelected = !this.triggers.testIsSelected
        },
        saveStudentData(studentName) {
            this.studentName.firstName = studentName.firstName.trim()
            this.studentName.secondName = studentName.secondName.trim()
            this.studentName.thirdName = studentName.thirdName.trim()
            this.triggers.loginIsDone = true
        },
        fetchLatestResult() {
            fetch('http://localhost:8080/api/answer/latest-result', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    username: (this.studentName.firstName + ' ' + this.studentName.secondName + ' ' + this.studentName.thirdName),
                    testId: this.selectedTest.id
                })
            })
                .then(response => response.json())
                .then(data => this.latestResultOfTest = data)
        }
    },
    created() {
        this.fetchTests()
    }
})