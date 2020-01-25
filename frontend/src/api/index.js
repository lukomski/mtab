import axios from 'axios';
export default {
	address: "http://localhost:8080",

	getCities: function() {
		return axios.get(this.address + '/cities',this, {})
	},
	getCountries: function() {
		return axios.get(this.address + '/countries',this, {})
	},
	getCountriesInfo: function() {
		return axios.get(this.address + '/countriesinfo',this, {})
	},
	getCountriesLanguage: function() {
		return axios.get(this.address + '/countrieslanguage',this, {})
	},
	setCityName: function (city_id, name) {
		return axios.put(this.address + '/city/' + city_id, this, {
			params: {
				name: name
			}
		})
	},
	deleteCity: function (city_id) {
		return axios.delete(this.address + '/city/' + city_id,this, {})
	},
	addCity: function (name, info, district) {
		return axios.post(this.address + '/cities', this, {
			params: {
				name: name,
				info: info,
				district: district
			}
		})
	}
}