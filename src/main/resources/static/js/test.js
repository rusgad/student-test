Vue.component('login-form', {
    data: function () {
        return {
            student: {
                studentName: {
                    firstName: '',
                    secondName: '',
                    thirdName: ''
                },
                password: ''
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
                    JSON.stringify(
                        {
                            username:
                                this.student.studentName.firstName.trim() + ' ' +
                                this.student.studentName.secondName.trim() + ' ' +
                                this.student.studentName.thirdName.trim(),
                            password: this.student.password
                        }
                    )
                )
            }).then(() => this.login())
        },
        login() {
            this.$emit('login', this.student)
        }
    },
    computed: {
        validationError() {
            if ((this.student.studentName.firstName.trim() == '') || (this.student.studentName.secondName.trim() == '') ||
                (this.student.studentName.thirdName.trim() == '') || (this.student.password.trim() == '')) {
                return true
            } else {
                return false
            }
        }
    },
    template:
        '<div class="row col-md-6 mx-auto">' +
            '<input v-model="student.studentName.firstName" placeholder="Фамилия" class="form-control mt-2" type="text">' +
            '<input v-model="student.studentName.secondName" placeholder="Имя" class="form-control mt-2" type="text">' +
            '<input v-model="student.studentName.thirdName" placeholder="Отчество" class="form-control mt-2" type="text">' +
            '<input v-model="student.password" placeholder="Пароль" class="form-control mt-2" type="text">' +
            '<button @click="postStudentData" :disabled="validationError" class="btn btn-primary mt-2">Сохранить</button>' +
        '</div>'
})

Vue.component('test-section', {
    props: ['student'],
    data() {
        return {
            tests: [],
            selectedTest: {},
            testIsSelected: false
        }
    },
    methods: {
        fetchTests() {
            fetch('http://localhost:8080/api/test')
                .then(response => response.json())
                .then(data => this.tests = data)
        },
        showOrHideTest() {
            this.testIsSelected = !this.testIsSelected
        },
        selectTestAndChangeComponent(testId) {
            for (let test of this.tests) {
                if (test.id == testId) {
                    this.selectedTest = test
                }
            }
            this.showOrHideTest()
        }
    },
    created() {
        this.fetchTests()
    },
    template:
        '<div v-if="!testIsSelected">' +
            '<h3 class="text-center m-4">' +
                'Здравствуйте, {{student.studentName.firstName}} {{student.studentName.secondName}}' +
            '</h3>' +
            '<div v-for="test in tests">' +
                '<div class="row input-group bg-light m-2 border border-secondary rounded">' +
                    '<h5 class="col-md-10 d-flex align-items-center m-0 col-8">{{ test.title }}</h5>' +
                    '<button @click="selectTestAndChangeComponent(test.id)" class="btn btn-primary m-0 col-md-2 col-4">' +
                        'Пройти тест' +
                    '</button>' +
                '</div>' +
            '</div>' +
        '</div>' +
        '<test v-else @return-back="showOrHideTest" :student="student" :selected-test="selectedTest"/>'
})

Vue.component('test', {
    props: ["selectedTest", "student"],
    data() {
        return {
            questionsWithOptions: [],
            selectedAnswers: [],
            triggers: {
                allQuestionAnswered: false,
                showResultTrigger: false,
                testIsComplete: false,
            }
        }
    },
    methods: {
        returnBack() {
            this.$emit('return-back')
        },
        fetchQuestionsWithOptions() {
            fetch('http://localhost:8080/api/question/' + this.selectedTest.id)
                .then(response => response.json())
                .then(questions => {
                    for (question of questions) {
                        let localQuestion = question
                        fetch('http://localhost:8080/api/option/' + question.id)
                            .then(response => response.json())
                            .then(options => {
                                this.questionsWithOptions.push({question: localQuestion, options: options, selectedAnswer: {}})
                            })
                    }
                })
        },
        saveTestResult() {
            if (this.triggers.allQuestionAnswered == true) {
                fetch('http://localhost:8080/api/answer', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(this.questionsWithOptions)
                })
                    .then(this.showResult)
                    .then(this.countRightAnswers)
            }
        },
        showResult() {
            this.triggers.testIsComplete = true
            this.triggers.showResultTrigger = true
        },
        // checkAnswersOnNull() {
        //     for (let item of this.questionsWithOptions) {
        //         if (item.pickedAnswer.optionText == null) {
        //             this.triggers.allQuestionAnswered = false
        //             break
        //         } else {
        //             this.triggers.allQuestionAnswered = true
        //         }
        //     }
        // },
        // countRightAnswers() {
        //     let questionQuantity = this.questionsWithOptions.length
        //     let rightAnswersCount = 0
        //     for (let answer of this.questionsWithOptions) {
        //         if (answer.pickedAnswer.right) {
        //             rightAnswersCount++
        //         }
        //     }
        //     return rightAnswersCount + '/' + questionQuantity
        // }
    },
    created() {
        this.fetchQuestionsWithOptions()
    },
    template:
        '<div class="container col-12 bg-light rounded border border-secondary mt-2 mb-2 p-2">' +
            '<div>' +
                '<h1 class="text-center mb-4">{{selectedTest.title}}</h1>' +
                '<div v-for="(questionWithOptions, index) in questionsWithOptions">' +
                    '<div class="m-2 p-2 rounded-3" ' +
                        '<h4>{{index + 1}}. {{questionWithOptions.question.questionText}}</h4>' +
                        '<div  v-for="option in questionWithOptions.options">' +
                            '<div class="rounded align-items-center d-flex p-1">' +
                                '<input class="form-check-input col-1 m-1" type="radio" ' +
                                        // '@change="checkAnswersOnNull" ' +
                                        ':disabled="triggers.testIsComplete"' +
                                        'v-bind:id="option.optionText"' +
                                        'v-bind:name="questionWithOptions.question.id"' +
                                        'v-bind:value="option" v-model="questionWithOptions.selectedAnswer"> ' +
                                '<label v-bind:for="option.optionText" class="form-check-label col-10 m-1 fs-5">' +
                                    '{{option.optionText}}' +
                                '</label>' +
                            '</div>' +
                        '</div>' +
                    '</div>' +
                '</div>' +
                '<div class="row justify-content-between m-3">' +
                    '<button @click="returnBack" class="col-3 btn btn-primary">Вернуться назад</button>' +
                    '<span v-show="triggers.showResultTrigger" class="col-3 text-center display-6">' +

                    '</span>' +
                    '<button @click="saveTestResult" :disabled="!triggers.allQuestionAnswered || triggers.testIsComplete"' +
                            ' class="col-3 btn btn-primary">Завершить тест</button>' +
                '</div>' +
            '</div>' +
        '</div>'
})

var app = new Vue({
    el: '#app',
    data: {
        userIsLoggedIn: false,
        student: {
            studentName: {
                firstName: '',
                secondName: '',
                thirdName: ''
            },
            password: ''
        }
    },
    methods: {
        saveStudentNameAndChangeComponent(student) {
            this.student.studentName.firstName = student.studentName.firstName
            this.student.studentName.secondName = student.studentName.secondName
            this.student.studentName.thirdName = student.studentName.thirdName
            this.student.password = student.password
            this.loginUser()
        },
        loginUser() {
            this.userIsLoggedIn = true
        }
    }
})