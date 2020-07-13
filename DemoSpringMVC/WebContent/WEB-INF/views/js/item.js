const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const itemId = urlParams.get('id');

var item = [];

axios({
	method : 'get',
	url : '/DemoSpringMVC/item/getItemById',
	params :{
		id: itemId
	}
}).then(function(res) {
	self.item = res.data;
	
	$("#cardTitle").text(self.item.name);
	$("#cardImg").attr("src", self.item.img);
});

function buyItem() {
	
}