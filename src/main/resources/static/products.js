$('#loadProducts').click(() => {

    $('.products-container').empty();

    fetch('http://localhost:8080/products') // Fetch the data (GET request)
        .then((response) => response.json()) // Extract the JSON from the Response
        .then((json) => json.forEach((product, idx) => { // Render the JSON data to the HTML

            let tableRow =
                '<tr>' +
                '<td>' + product.name + '</td>' +
                '<td>' + product.description + '</td>' +
                '<td>' +
                '<button>Delete</button>' +
                '</td>' +
                '</tr>';

            $('.products-container').append(tableRow);
        }));
});
