(function () {
	angular.module('crudModule', ['restangular'])
        .config(crudConfig);
        
        function crudConfig(RestangularProvider) {
            RestangularProvider.setBaseUrl('webresources');

            RestangularProvider.addRequestInterceptor(req);
            RestangularProvider.addResponseInterceptor(res);
            
            function req(data, operation) {
                var ans = data;
                if (operation === 'remove')
                    ans = null;
                return ans;
            }
            
            function res(data, operation) {
                var ans = null;
                if (operation === 'getList') {
                    if (data.constructor === Array){
                        ans = data;
                    } else {
                        angular.forEach(data, check);
                        function check(value, index) {
                            if (value.constructor === Array)
                                ans = value;
                        }
                    }
                } else {
                    ans = data;
                }
                return ans;
            }
        }
})();