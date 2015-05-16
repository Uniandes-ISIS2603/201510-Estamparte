(function () {
	angular.module('mockModule', ['ngMockE2E'])
	.run(runMocks);

	function runMocks($httpBackend, mock) {

		var mocks = {};

		// This variable helps as a button for enabling
		// or not the mock in a fast way.
		var skip = true;

		// ================================================================================
		// THIS IS THE TEMPLATE HANDLER
		// ================================================================================

		var url = new RegExp('([^]+).html$');
		$httpBackend.whenGET(url).passThrough();

		// ================================================================================
		// THIS IS THE BASIC MOCK CREATOR
		// ================================================================================

		function addBasicMock(basic, skip) {
			if (!mocks.hasOwnProperty(basic)) mocks[basic] = {};

			var base = '/' + basic;
			var url    = new RegExp(base + '$');
			var regUrl = new RegExp(base + '/([0-9]+)$');

			if (!skip) {
				$httpBackend.whenGET(url).respond(doGET);
				$httpBackend.whenGET(regUrl).respond(doGETID);
				$httpBackend.whenPOST(url).respond(doPOST);
				$httpBackend.whenPUT(regUrl).respond(doPUT);
				$httpBackend.whenDELETE(regUrl).respond(doDELETE);
			} else {
				var skipUrl = new RegExp('([^]+)');

				$httpBackend.whenGET(skipUrl).passThrough();
				$httpBackend.whenGET(skipUrl).passThrough();
				$httpBackend.whenPOST(skipUrl).passThrough();
				$httpBackend.whenPUT(skipUrl).passThrough();
				$httpBackend.whenDELETE(skipUrl).passThrough();
			}

			// /:basic
			function doGET(method, url, data) {
				var ans = []
				angular.forEach(mocks[basic], forEach);
				function forEach(value, index) {
					ans.push(value);
				}
				return [200, ans, {}];
			}

			// /:basic/:id
			function doGETID(method, url, data) {
				var id = url.split('/').pop();
					item = mocks[basic][id];
				return [200, item, {}];
			}

			// /:basic
			function doPOST(method, url, data) {
				var item = angular.fromJson(data),
					id = Math.floor(Math.random() * 10000);
				item['id'] = id;
				mocks[basic][id] = item;
				return [200, item, {}];
			}

			// /:basic/:id
			function doPUT(method, url, data) {
				var item = angular.fromJson(data),
					id = url.split('/').pop();
				mocks[basic][id] = item;
				return [200, item, {}];
			}

			// /:basic/:id
			function doDELETE(method, url, data) {
				var item = null, id = url.split('/').pop();
				delete mocks[basic].id;
				return [200, item, {}];
			}
		}

		// ================================================================================
		// THIS IS THE CUSTOM MOCK CREATOR
		// ================================================================================

		function addCustomMock(basic, custom, skip) {

			if (!mocks.hasOwnProperty(custom)) addBasicMock(custom);

			var base = new RegExp('/' + basic + '/([0-9]+)/' + custom);
			var url = new RegExp(base);
			var regUrl = new RegExp(base + '/([0-9]+)');

			if (!skip) {
				$httpBackend.whenGET(url).respond(doGET);
				$httpBackend.whenGET(regUrl).respond(doGETID);
				$httpBackend.whenPOST(url).respond(doPOST);
				$httpBackend.whenPUT(regUrl).respond(doPUT);
				$httpBackend.whenDELETE(regUrl).respond(doDELETE);
			} else {
				var skipUrl = new RegExp('([^]+)');

				$httpBackend.whenGET(skipUrl).passThrough();
				$httpBackend.whenGET(skipUrl).passThrough();
				$httpBackend.whenPOST(skipUrl).passThrough();
				$httpBackend.whenPUT(skipUrl).passThrough();
				$httpBackend.whenDELETE(skipUrl).passThrough();
			}

			// /:basic/:id/:custom
			function doGET(method, url, data) {
				var spl = url.split('/'); spl.pop();
				var ans = [], basicID = spl.pop();
				angular.forEach(mocks[custom], forEach);
				function forEach(value, index) {
					if (value[basic] === basicID) ans.push(value);
				}
				return [200, ans, {}];
			}

			// /:basic/:id/:custom/:id
			function doGETID(method, url, data) {
				var spl = url.split('/'), customID = spl.pop(); spl.pop(); 
				var basicID = spl.pop(), item = mocks[custom][customID];
				if (item[basic] !== basicID) item = null;
				return [200, item, {}];
			}

			// /:basic/:id/:custom
			function doPOST(method, url, data) {
				var spl = url.split('/'); spl.pop();
				var basicID = spl.pop(),
					customID = Math.floor(Math.random() * 10000);
					item = angular.fromJson(data),
				item['id'] = customID;
				item[basic] = basicID;
				mocks[custom][customID] = item;
				return [200, item, {}];
			}

			// /:basic/:id/:custom/:id
			function doPUT(method, url, data) {
				var spl = url.split('/'), customID = spl.pop(); spl.pop();
				var basicID = spl.pop(), item = angular.fromJson(data),
					oldItem = mocks[custom][customID];
				if (oldItem[basic] === basicID) mocks[custom][customID] = item;
				return [200, item, {}];
			}

			// /:basic/:id/:custom/:id
			function doDELETE(method, url, data) {
				var spl = url.split('/'), customID = spl.pop(); spl.pop(); 
				var basicID = spl.pop(), item = mocks[custom][customID];
				if (item[basic] === basicID) delete mocks[custom].customID;
				return [200, item, {}];
			}
		}

		var basicRegs = mock.getBasicRegs();
		angular.forEach(basicRegs, addBasic);
		function addBasic(value, index) {
			addBasicMock(value, skip);
			console.log('Agregado para ' + value);
		};

		var customRegs = mock.getCustomRegs();
		angular.forEach(customRegs, addCustom);
		function addCustom(value, index) {
			addCustomMock(value[0], value[1], skip);
		};
	}
})();