(function () {
	angular.module('crudModule')
	.service('crudService', crudService);

	function crudService(Restangular) {

		var _this = this;

		_this.extendService = extendService;

		function extendService(_this, basic, custom) {

			// A container for both basic and custom records.
			_this.records = {
				basicRecords: [],
				customRecords: []
			}

			// An auxiliary function used to return the
			// retrieved data from the requests.
			function returnRecords(data) {
				return data;
			}

			// ######################################################
			// ################### GET Section ######################
			// ######################################################

			_this.getBasic = getBasic;
			_this.getBasicID = getBasicID;
			_this.getCustom = getCustom;
			_this.getCustomID = getCustomID;

			// GET all basic items as a list.
			function getBasic() {
				return Restangular.all(basic).getList().then(getResolveBasic);
			}

			// GET one basic item using it's ID.
			function getBasicID(basicID) {
				return Restangular.one(basic, basicID).get();
			}
			
			// GET all custom items as a list.
			function getCustom(basicID) {
				return Restangular.one(basic, basicID).getList(custom).then(getResolveCustom);
			}

			// GET one custom item using it's ID.
			function getCustomID(basicID, customID) {
				return Restangular.one(basic, basicID).one(custom, customID).get();
			}

			// ######################################################
			// ################### POST Section #####################
			// ######################################################

			_this.postBasic = postBasic;
			_this.postCustom = postCustom;

			// POST a basic item.
			function postBasic(data) {
				return Restangular.all(basic).post(data).then(reloadResolveBasic);
			}

			// POST a custom item.
			function postCustom(data, basicID) {
				return Restangular.one(basic, basicID).post(custom, data).then(resolve);
				function resolve(entry) {
					reloadResolveCustom(entry, basicID);
				}
			}

			// ######################################################
			// ################### PUT Section ######################
			// ######################################################

			_this.putBasic = putBasic;
			_this.putCustom = putCustom;

			// PUT a basic item.
			function putBasic(data) {
				return data.put().then(reloadResolveBasic);
			}

			// PUT a custom item.
			function putCustom(data, basicID) {
				return data.put().then(resolve);
				function resolve(entry) {
					reloadResolveCustom(entry, basicID);
				}
			}

			// ######################################################
			// ################# DELETE Section #####################
			// ######################################################

			_this.deleteBasic = deleteBasic;
			_this.deleteCustom = deleteCustom;

			// DELETE a basic item.
			function deleteBasic(data) {
				return data.remove().then(reloadResolveBasic);
			}

			// DETE a custom item.
			function deleteCustom(data, basicID) {
				var entry = JSON.parse(JSON.stringify(data));
				return data.remove().then(resolve);
				function resolve() {
					reloadResolveCustom(entry, basicID);
				}
			}

			// ######################################################
			// ################### AUX Section ######################
			// ######################################################

			// Resolve the GET method assigning the data to an array.
			// This is only for basic list GET.
			function getResolveBasic(data) {
				_this.records.basicRecords = data;
				return _this.basicRecords;
			}

			// Resolve the GET method assigning the data to an array.
			// This is only for custom list GET.
			function getResolveCustom(data) {
				_this.records.customRecords = data;
				return _this.customRecords;
			}

			// Resolve POST, PUT, or DELETE methods making a GET to
			// reload the data. This is only for basic methods.
			function reloadResolveBasic(entry) {
				return getBasic().then(returnEntry);
				function returnEntry() {
					return entry;
				}
			}

			// Resolve POST, PUT, or DELETE methods making a GET to
			// reload the data. This is only for custom methods.
			function reloadResolveCustom(entry, basicID) {
				return getCustom(basicID).then(returnEntry);
				function returnEntry() {
					return entry;
				}
			}
		}
	}
})();