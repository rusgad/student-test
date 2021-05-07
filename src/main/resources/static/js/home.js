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
            fetch('http://192.168.31.49:8080/api/students', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: (this.studentName.firstName + ' ' + this.studentName.secondName + ' ' + this.studentName.thirdName)
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
    template:
        '<div>' +
            '<input type="text" v-model="studentName.firstName" placeholder="Фамилия">' +
            '<input type="text" v-model="studentName.secondName" placeholder="Имя">' +
            '<input type="text" v-model="studentName.thirdName" placeholder="Отчество">' +
            '<button @click="postStudentData">Сохранить</button>' +
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
        saveResult() {
            this.$emit('save-result')
        }
    },
    template:
        '<div>' +
            '<div v-for="(questionAndOptions, index) in questionsAndOptions">' +
                '<h4>{{index + 1}}. {{questionAndOptions.question.questionText}}</h4>' +
                '<div v-for="option in questionAndOptions.options">' +
                    '<input type="radio" v-bind:id="option.optionText" v-bind:name="questionAndOptions.question.id"' +
                    'v-bind:value="option" v-model="questionAndOptions.pickedAnswer">' +
                    '<label v-bind:for="option.optionText">{{option.optionText}}</label>' +
                '</div>' +
            '</div>' +
            '<button @click="returnBack">Вернуться назад</button>' +
            '<button @click="saveResult">Сохранить результат</button>' +
        '</div>'
})


var app = new Vue({
    el: '#app',
    data: {
        tests: [],
        selectedTest: {},
        questionsAndOptions: [],
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
            fetch('http://192.168.31.49:8080/api/test')
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
            fetch('http://192.168.31.49:8080/api/question/' + this.selectedTest.id)
                .then(response => response.json())
                .then(data => this.questionsAndOptions = data)
        },
        changeQuestionTrigger() {
            this.triggers.testIsSelected = !this.triggers.testIsSelected
        },
        saveResult() {
            alert("save is going")
        },
        saveStudentData(studentName) {
            this.studentName.firstName = studentName.firstName
            this.studentName.secondName = studentName.secondName
            this.studentName.thirdName = studentName.thirdName
            this.triggers.loginIsDone = true
        }
    },
    created() {
        this.fetchTests()
    }
})