angular.module('university-front', []).controller('appController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/university/api/v1';

    let currentPageIndex = 1;
    $scope.loadStudents = function (pageIndex = 1) {
        currentPageIndex = pageIndex;
        $http({
            url: contextPath + '/students',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.studentsPage = response.data;
            $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.studentsPage.totalPages);
        });
    }


    $scope.showInfo = function (student) {
        alert(student.name);
    }

    $scope.delete = function (student){
        $http({
            url: contextPath + '/students/delete/' + student.id,
            method: 'DELETE'
        }).then(function (response) {
            console.log(response);
            $scope.loadStudents(currentPageIndex);
        });
    }

    $scope.createNewStudent = function () {
        $http.post(contextPath + '/students', $scope.new_student)
            .then(function successCallback(response) {
                    $scope.loadStudents(currentPageIndex);
                    $scope.new_student = null;
                }, function failCallback(response) {
                    alert(response.data.message);
                }
            );
    }

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.nextPage = function () {
        currentPageIndex++;
        if (currentPageIndex > $scope.studentsPage.totalPages) {
            currentPageIndex = $scope.studentsPage.totalPages;
        }
        $scope.loadStudents(currentPageIndex);
    }

    $scope.prevPage = function () {
        currentPageIndex--;
        if (currentPageIndex < 1) {
            currentPageIndex = 1;
        }
        $scope.loadStudents(currentPageIndex);
    }

    $scope.loadStudents(1);



});