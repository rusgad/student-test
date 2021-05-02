var app = new Vue({
    el: '#app',
    data: {
        tests: [],
        questions: []
    },
    methods: {
        fetchQuestions() {
            fetch('http://192.168.31.49:8080/questions')
                .then(response => response.json())
                .then(data => this.questions = data)
        }
    },
    created() {

    }
})