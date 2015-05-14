(function () {
	angular.module('crudModule', ['restangular'])
        .config(crudConfig);
        
        function crudConfig(RestangularProvider) {
            RestangularProvider.setBaseUrl('webresources');

            RestangularProvider.addRequestInterceptor(req);
            RestangularProvider.addResponseInterceptor(res);
            
            function req(data, operation) {
                var ans = data;
                if (operation === "remove")
                    ans = null;
                return ans;
            }
            
            function res(data, operation) {
                var ans = null;
                if (operation === "getList") {
                    angular.forEach(data, check);
                    function check(value, index) {
                        if (value.constructor === Array)
                            ans = value;
                    }
                } else {
                    ans = data;
                }
                console.log(ans);
                return ans;
            }
        }
})();