$('#loadCategories').click(() => {

    $('.categories-container').empty();
    $('.products-container').empty();

    fetch('http://localhost:8080/categories') // Fetch the data (GET request)
        .then((response) => response.json()) // Extract the JSON from the Response
        .then((json) => json.forEach((category, idx) => { // Render the JSON data to the HTML

            let tableRow =
                '<tr>' +
                '<td>' + category.categoryName + '</td>' +
                '<td>' + category.description + '</td>' +
                '<td><button class="product-btn" data-category-id="' + category.id + '">Show Products</button></td>' +
                '<td>' +
                '<button>Delete</button>' +
                '</td>' +
                '</tr>';

            $('.categories-container').append(tableRow);
        }));
});

$('body').on('click', 'button.product-btn', function() {
    let categoryId = $(this).data('category-id');
    console.log("Category ID is " + categoryId)

    $('.products-container').empty();

    fetch('http://localhost:8080/categories/'+categoryId+'/products') // Fetch the data (GET request)
        .then((response) => response.json()) // Extract the JSON from the Response
        .then((json) => json.forEach((product, idx) => { // Render the JSON data to the HTML
            console.log(product.name);

            let tableRow =
                '<tr>' +
                '<td>' + product.name + '</td>' +
                '<td>' +
                '<button>Delete</button>' +
                '</td>' +
                '</tr>';

            $('.products-container').append(tableRow);
        }));

});
