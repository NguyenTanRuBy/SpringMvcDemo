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
	})
	.then( async function(res) {
		self.itemByCategory = res.data;
		console.log(self.itemByCategory);
		
		/// rename category
		$("#categoryViewer").html("<H3>" + button.id + "</H3>");
		$("#categoryViewer").append("<div class='card-deck' id='categoryViewerCardDeck'></div>")
		
		$("#categoryViewer")[0].scrollIntoView(false);
		
		for(let item = 0; item <= self.itemByCategory.length; item++) {
			$("#categoryViewerCardDeck").append("\
					<div class='card mb-4'>\
						<img class='card-img-top' src='" + self.itemByCategory[item].img + "'\
							alt='Card image'>\
						<div class='card-body'>\
							<h4 class='card-title'>"+self.itemByCategory[item].name+"</h4>\
							<p class='card-text'>Description</p>\
							<a href='#' class='btn btn-success'>Detail</a>\
						</div>\
					</div>")
}
		});

		
		
}

