Vue.component('test', {
    props: ["selectedTest", "questionsAndOptions"],
    data: function () {
        return {

        }
    },
    template: 
        '<div>' +
            '<div v-for="(questionAndOptions, index) in questionsAndOptions">' +
                '<h4>{{index + 1}}. {{questionAndOptions.question.questionText}}</h4>' +
                '<div v-for="option in questionAndOptions.options">' +
                    '<input type="radio" v-bind:id="option.optionText" v-bind:name="questionAndOptions.question.id" v-bind:value="option" v-model="questionAndOptions.pickedAnswer">' +
                    '<label v-bind:for="option.optionText">{{option.optionText}}</label>' +
                '</div>' +
            '</div>' +
            '<button>Вернуться назад</button>' +
            '<button>Сохранить результат</button>' +
        '</div>'
})



var app = new Vue({
    el: '#app',
    data: {
        tests: [],
        selectedTest: {},
        questionsAndOptions: [],
        triggers: {
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
            this.showQuestions()
        },
        fetchQuestions() {
            fetch('http://192.168.31.49:8080/api/question/' + this.selectedTest.id)
                .then(response => response.json())
                .then(data => this.questionsAndOptions = data)
        },
        showQuestions() {
            this.triggers.testIsSelected = !this.triggers.testIsSelected
        }
    },
    created() {
        this.fetchTests()
    }
})