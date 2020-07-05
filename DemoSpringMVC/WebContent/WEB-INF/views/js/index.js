var items = [];

function getAllItem() {
	var self = this;
	axios({
		method : 'get',
		url : '/DemoSpringMVC/item/getAllItem'
	}).then(function(res) {
		self.items = res.data;
		console.log(self.items);
	});
}
