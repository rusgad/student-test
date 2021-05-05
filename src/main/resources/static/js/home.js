var app = new Vue({
    el: '#app',
    data: {
        tests: []
    },
    methods: {
        fetchTests() {
            fetch('http://192.168.31.49:8080/api/test')
                .then(response => response.json())
                .then(data => this.tests = data)
        },
        goToTest(testId) {
            window.location.href = 'http://192.168.31.49:8080/test/' + testId
        }
    },
    created() {
        this.fetchTests()
    }
})