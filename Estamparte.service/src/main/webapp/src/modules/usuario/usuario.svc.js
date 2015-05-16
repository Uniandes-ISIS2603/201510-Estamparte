(function () {
	angular.module('usuarioModule')
	.service('usuarioService', usuarioService);

<<<<<<< HEAD
	function usuarioService($rootScope, carritoService, compradorService, artistaService, formaPagoService) {

=======
	function usuarioService($rootScope, compradorService, artistaService) {
                    
>>>>>>> 30033c04cea827165aba1c39140175169fcdb5ff
		var _this = this;

		_this.user = {};

		_this.signup = signup;
		_this.login = login;
		_this.logout = logout;
		_this.getUser = getUser;
		_this.getName = getName;
		_this.getType = getType;

		// Signup a new user, adding it to the DB. If the user
		// is of type 'comprador', it adds algo a new cart.
		function signup(user, type, callback) {
			console.log(user); console.log(type);
			if (type === 'artista')
				artistaService.postBasic(user).then(preSetOnline);
			else if (type === 'comprador')
				carritoService.postBasic({}).then(resolveSignup);
			function resolveSignup(carrito) {
				user.idCarrito = carrito.idCarrito;
				compradorService.postBasic(user).then(preSetOnline);
			}
			function preSetOnline(target) {
				setOnline(target, type, callback);
			}
		}

		// Fill user object properties with the one of the
		// given object by arg, making the user online.
		function setOnline(target, type, callback) {
			_this.user.tipo = type;
			angular.forEach(target, set);
			function set(value, key) {
				_this.user[key] = value;
			}
			if (type === 'comprador') formaPagoService.getCustom(_this.user.id);
			if (callback) callback();
		}

		// Verify the user credentials in all the user records
		// available in the system, returns 1 for success or 0.
		function login(target, callback) {
			compradorService.getBasic().then(artistaService.getBasic().then(search));
			function search() {
				var ans = null, type = '';
				angular.forEach(compradorService.records.basicRecords, findComprador);
				angular.forEach(artistaService.records.basicRecords, findArtista);
				function findArtista(value, key) {
					if (target.usr === value.usuario && target.pwd === value.contrasenha) {
						ans = value;
						type = 'artista';
					}
				}
				function findComprador(value, key) {
					if (target.usr === value.usuario && target.pwd === value.clave) {
						ans = value;
						type = 'comprador';
					}
				}
				return resolveLogin(ans, type);
			}
			function resolveLogin(ans, type) {
				if (ans !== null) setOnline(ans, type);
				if (callback) return callback(ans);
				else return ans;
			}
		}

		// Logout the current user making it null.
		function logout() {
			angular.forEach(_this.user, rem);
			function rem(value, key) {
				delete _this.user[key];
			}
		}

		// Returns the current logged user (can be null).
		function getUser() {
			return _this.user;
		}

		// Returns the user name based on it's name and type.
		// If there is no user, returns an empty string.
		function getName() {
			var ans = '';
			if (_this.user.id) {
				ans = _this.user.nombre;
				if (_this.user.tipo === 'artista') {
					ans += ' el artista';
				} else if (_this.user.tipo === 'comprador') {
					ans += ' el comprador';
				} else {
					logout();
					ans = '';
				}
			}
			return ans;
		}

		// Returns the user type. If there is no user,
		// returns null.
		function getType() {
			var ans = null;
			if (_this.user.id) {
				ans = _this.user.tipo;
			}
			return ans;
		}
	}
})();