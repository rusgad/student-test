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
                body: (this.studentName.firstName.trim() + ' ' + this.studentName.secondName.trim() + ' ' + this.studentName.thirdName.trim())
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


Vue.component('test', {
    props: ["selectedTest", "questionsAndOptions"],
    data: function () {
        return {

        }
    },
    methods: {
        returnBack() {
            this.$emit('return-back')
        },
        saveTestResult() {
            fetch('http://localhost:8080/api/answer', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.questionsAndOptions)
            })
        }
    },
    template:
        '<div class="container bg-light rounded border mt-2 p-2">' +
            '<h1 class="text-center mb-4">{{selectedTest.title}}</h1>' +
            '<div v-for="(questionAndOptions, index) in questionsAndOptions">' +
                '<h4>{{index + 1}}. {{questionAndOptions.question.questionText}}</h4>' +
                '<div v-for="option in questionAndOptions.options">' +
                    '<input class="form-check-input" type="radio" v-bind:id="option.optionText" v-bind:name="questionAndOptions.question.id"' +
                    'v-bind:value="option" v-model="questionAndOptions.pickedAnswer"> ' +
                    '<label class="form-check-label fs-5" v-bind:for="option.optionText">{{option.optionText}}</label>' +
                '</div>' +
            '</div>' +
            '<div class="row justify-content-between m-3">' +
                '<button class="col-3 btn btn-primary" @click="returnBack">Вернуться назад</button>' +
                '<button class="col-3 btn btn-primary" @click="saveTestResult">Завершить тест</button>' +
           '</div>' +
        '</div>'
})


var app = new Vue({
    el: '#app',
    data: {
        tests: [],
        selectedTest: {},
        questionsAndOptions: [],
        resultOfTesting: [],
        triggers: {
            loginIsDone: false,
            testIsSelected: false
        },
        studentName: {
            firstName: '',
            secondName: '',
            thirdName: ''
        },
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
                .then(data => this.questionsAndOptions = data)
        },
        changeQuestionTrigger() {
            this.triggers.testIsSelected = !this.triggers.testIsSelected
        },
        saveStudentData(studentName) {
            this.studentName.firstName = studentName.firstName.trim()
            this.studentName.secondName = studentName.secondName.trim()
            this.studentName.thirdName = studentName.thirdName.trim()
            this.triggers.loginIsDone = true
        }
    },
    created() {
        this.fetchTests()
    }
})