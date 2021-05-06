var app = new Vue({
    el: '#app',
    data: {
        tests: [],
        studentName: {
            firstName: '',
            secondName: '',
            thirdName: ''
        }
    },
    methods: {
        fetchTests() {
            fetch('http://192.168.31.49:8080/api/test')
                .then(response => response.json())
                .then(data => this.tests = data)
        },
        postStudentData() {
            fetch('http://192.168.31.49:8080/api/students', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: (this.studentName.firstName + ' ' + this.studentName.secondName + ' ' + this.studentName.thirdName)
            })
            this.studentName.firstName = ''
            this.studentName.secondName = ''
            this.studentName.thirdName = ''
        },
        goToTest(testId) {
            window.location.href = 'http://192.168.31.49:8080/test' + testId
        }
    },
    created() {
        this.fetchTests()
    }
})