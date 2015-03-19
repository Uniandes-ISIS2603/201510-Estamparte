(function () {
    var app = angular.module('MockModule');

    app.value('MockModule.mockRecords', {});

    app.provider('MockModule.urls', function () {
        var context = [];
        this.registerUrl = function (value) {
            context.push(value);
        };
        this.$get = function () {
            return context;
        };
    });
})();