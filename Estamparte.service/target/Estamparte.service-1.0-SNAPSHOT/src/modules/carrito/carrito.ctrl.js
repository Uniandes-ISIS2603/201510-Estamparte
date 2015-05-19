(function () {	
	angular.module('carritoModule')
	.controller('carritoController', carritoController);

	function carritoController(formaPagoService, camisetaService, carritoService, usuarioService, facturaService) {
		
		var _this = this;

		// Hold all payments.
		_this.formaPagoRecords = formaPagoService.records;

		// Hold all tshirts.
		_this.carritoRecords = carritoService.records;

		// Hold the payment.
		_this.payment = null;

		_this.editTshirt = editTshirt;
		_this.getUserType = getUserType;
		_this.invalidOrder = invalidOrder;
		_this.isNegative = isNegative;
		_this.removeTshirt = removeTshirt;
		_this.cleanCart = cleanCart;
		_this.changeAmount = changeAmount;
		_this.getPrice = getPrice
		_this.buy = buy;
		_this.getTodayDate = getTodayDate;

		// Edit the selected tshirt.
		function editTshirt(target) {
			camisetaService.setTshirtDefaults();
			angular.forEach(target, copy);
			function copy(value, key) {
				camisetaService.tshirt[key] = value;
			}
			camisetaService.setCSS();
		}

		// Returns the user type
		function getUserType() {
			return usuarioService.getType();
		}

		// Check that the order is valid.
		function invalidOrder() {
			return  _this.payment === null ||
					_this.carritoRecords.customRecords.length === 0 ||
					_this.isNegative() ||
					_this.getUserType() === null;
		}

		// Check that there is no negative amount of tshirts.
		function isNegative() {
			var ans = false;
			angular.forEach(_this.carritoRecords.customRecords, check);
			function check(value, index) {
				if (value.cantidad <= 0) ans = true;
			}
			return ans;
		}

		// Remove the tshirt from the cart.
		function removeTshirt(target) {
			carritoService.deleteCustom(target, usuarioService.getCarrito()).then(camisetaService.setTshirtDefaults);
		}

		// Clean the cart.
		function cleanCart() {
			if (_this.carritoRecords.customRecords.length > 0) {
				var id = usuarioService.getUser().id,
					current = _this.carritoRecords.customRecords[0];
				carritoService.deleteCustom(current, id).then(cleanCart);
			}
		}

		// Updates tshirt's amount.
		function changeAmount(target) {
			carritoService.putCustom(target, usuarioService.getCarrito());
		}

		// Returns the total tshirt price.
		function getPrice() {
			var ans = 0;
			angular.forEach(_this.carritoRecords.customRecords, add);
			function add(value, key) {
				ans += value.costo * value.cantidad;
			}
			return ans;
		}

		// Makes the transaction.
		function buy() {
			var id = usuarioService.getUser().id;
			camisetaService.setTshirtDefaults();
			var result = {
				idComprador: id,
				idFormaPago: _this.payment.id,
				fechaCompra: getTodayDate(),
				idCarrito: usuarioService.getCarrito(),
				monto: getPrice()
			};
			facturaService.postCustom(result, id).then(cleanCart);
		}

		// Returns a valid string of today date.
		function getTodayDate() {
			var d = new Date();
			return d.getDate() + "/" + (d.getMonth()+1) + "/" + d.getFullYear();
		}
	}
})();