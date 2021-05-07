var app = new Vue({
    el: '#app',
    data: {
        username: '',
        students: [],
        questionsWithOptions: [],
        currentUrl: window.location.href
    },
    methods: {
        fetchStudents() {
            fetch('http://192.168.31.49:8080/api/students')
                .then(response => response.json())
                .then(data => this.students = data);
        },
        fetchQuestions() {
            fetch('http://192.168.31.49:8080/api/question/' + this.testId)
                .then(response => response.json())
                .then(data => this.questionsWithOptions = data)
        }
    },
    created() {
        this.fetchQuestions()
    },
    computed: {
        testId() {
            return this.currentUrl.substr(31)
        }
    }
})