(function () {
	angular.module('usuarioModule')
	.service('usuarioService', usuarioService);

	function usuarioService($rootScope, compradorService, artistaService) {
                    
		var _this = this;

		_this.user = null;

		_this.login = login;
		_this.logout = logout;
		_this.getUser = getUser;
		_this.getName = getName;
		_this.getType = getType;

		// Verify the user credentials in all the user records
		// available in the system, returns 1 for success or 0.
		function login(usr, pwd) {
			var ans = 0;
			if (_this.user === null) {
				compradorService.getBasic().then(tryFind);
				function tryFind(records) {
					var ans = checkUser(records);
					if (ans === 0) {
						return artistaService.getBasic.then(checkUser)
					} else {
						return ans;
					}
				}
				function checkUser(records) {
					angular.forEach(records, search);
					function search(value, index) {
						if (usr === value.usuario && pwd === value.pwd) {
							_this.user = value;
							ans = 1;
						}
					}
				}
			} else {
				ans = 1;
			}
			return ans;
		}

		// Logout the current user making it null.
		function logout() {
			_this.user = null;
		}

		// Returns the current logged user (can be null).
		function getUser() {
			return _this.user;
		}

		// Returns the user name based on it's name and type.
		// If there is no user, returns an empty string.
		function getName() {
			var ans = '';
			if (_this.user !== null) {
				ans = _this.user.nombre;
				if (_this.user.tipo === 'artista') {
					ans += ' el artista';
				} else if (_this.user.tipo === 'comprador') {
					ans += ' el comprador';
				} else {
					_this.user = null;
					ans = '';
				}
			}
			return ans;
		}

		// Returns the user type. If there is no user,
		// returns null.
		function getType() {
			var ans = null;
			if (_this.user !== null) {
				ans = _this.user.tipo;
			}
			return ans;
		}

		// TEST TEST TEST !!!!!!!!!!!
		// Here we add a user for test purposes.
		testComprador();
		function testComprador() {
			var testUser = {
				tipo: 'comprador',
				usuario: 'jcbages',
				constrasenha: '123456',
				nombre: 'Juan Camilo',
				cedula: '1020808646',
				correo: 'jcbages@outlook.com',
				imagenPerfil: '',
				descripcion: 'Un gran hombre, con un gran sueño.'   
			};
			compradorService.postBasic(testUser).then(log);
			function log(entry) {
				_this.user = entry;
			}
		}

		// TEST TEST TEST !!!!!!!!!!!
		// Here we add a user for test purposes.
		testArtista();
		function testArtista() {
			var testUser = {
				tipo: 'artista',
				usuario: 'acfandino',
				constrasenha: '123456',
				nombre: 'Ana Camila',
				cedula: '1012512929',
				correo: 'camifandu@hotmail.com',
				imagenPerfil: '',
				descripcion: 'Una gran mujer, con un gran sueño.'   
			};
			artistaService.postBasic(testUser);
		}
	}
})();