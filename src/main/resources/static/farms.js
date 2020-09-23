$('#loadFarms').click(() => {

    $('.farms-container').empty();
    $('.products-container').empty();

    fetch('http://localhost:8080/farms') // Fetch the data (GET request)
        .then((response) => response.json()) // Extract the JSON from the Response
        .then((json) => json.forEach((farm, idx) => { // Render the JSON data to the HTML

            let tableRow =
                '<tr>' +
                '<td>' + farm.name + '</td>' +
                '<td>' + farm.email + '</td>' +
                '<td><button class="product-btn" data-farm-id="' + farm.id + '">Show Products</button></td>' +
                '<td>' +
                '<button>Delete</button>' +
                '</td>' +
                '</tr>';

            $('.farms-container').append(tableRow);
        }));
});

$('body').on('click', 'button.product-btn', function() {
    let farmId = $(this).data('farm-id');
    console.log("Category ID is " + farmId)

    $('.products-container').empty();

    fetch('http://localhost:8080/farms/'+farmId+'/products') // Fetch the data (GET request)
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
