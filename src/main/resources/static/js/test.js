var app = new Vue({
    el: '#app',
    data: {
        tests: [],
        questions: [],
        currentUrl: window.location.href
    },
    methods: {
        fetchQuestions() {
            fetch('http://192.168.31.49:8080/questions')
                .then(response => response.json())
                .then(data => this.questions = data)
        },

    },
    created() {

    },
    computed: {
        testId() {
            return this.currentUrl.substr(31)
        }
    }
})