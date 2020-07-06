var items = [];
var itemByCategory = [];
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

function categoryClick(button) {
	var self = this;
	var requestUrl = '/DemoSpringMVC/item/getItemByCategory?name=' + button.id;
	axios({
		method : 'get',
		url : requestUrl
	}).then(function(res) {
		self.itemByCategory = res.data;
		console.log(self.itemByCategory);
	});
}

