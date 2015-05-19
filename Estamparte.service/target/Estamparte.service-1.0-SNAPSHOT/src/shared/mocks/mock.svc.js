(function () {
    angular.module('mockModule')
    .provider('mock', mockProvider);

    function mockProvider() {

        var _this = this;

        _this.basicRegs = [];
        _this.customRegs = [];

        _this.getBasicRegs = getBasicRegs;
        _this.getCustomRegs = getCustomRegs;
        _this.addBasicReg = addBasicReg;
        _this.addCustomReg = addCustomReg;
        
        _this.$get = $get;

        function getBasicRegs() {
            return _this.basicRegs;
        }

        function getCustomRegs() {
            return _this.customRegs;
        }

        function addBasicReg(basic) {
            _this.basicRegs.push(basic);
        }

        function addCustomReg(basic, custom) {
            _this.customRegs.push([basic, custom]);
        }

        function $get() {
            return {
                getBasicRegs: getBasicRegs,
                getCustomRegs: getCustomRegs
            };
        }
    }
})();