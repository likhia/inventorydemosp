
var productsVal = {
            'furniture': {
                '988e65f7-6f63-4c3f-b086-9ea4224733db': ['Stackable Shoe Rack', '15.50', '10'],
                '6e762720-5827-439b-a9d8-38a8c6ca5d10': ['Storage Tool', '8.50', '15']
            },
            'applicance': {
                '663ca5a4-4133-4240-b925-f5d4b9ad6a7c': ['Toaster', '25.00', '1'],
                '46b22ef0-5507-4e8f-9e02-16c2dcf71220': ['Juicer','85.90', '2'],
                'e9e4246e-82d8-40ec-9e5b-343a0afdea5a': ['Slow Cooker', '55.50', '3']
            },
            'skin': {
                '289b459c-0fe5-494c-a712-87b7328b07bf': ['Facial Wash', '7.90', '1'],
                'f4aed3c4-c91d-4ced-a62f-9fd999af0cb5': ['Essence', '20.50', '2'],
                'b6bd73c3-d154-4660-b0df-2e95ff2f0588' : ['Toner','15.50', '3']
            },
            'body': {
                '8117917f-f3ad-4e62-93d4-0fe724f2d87e': ['Hand Soap', '8.90', '1'],
                '00bf6a15-1b85-4257-bdda-584802ed03a5': ['Body Foam', '3.60', '2']
            }
        }

    function listProducts() {
        var categoryList = document.getElementById("category");  
        var selectedCategory = categoryList.options[categoryList.selectedIndex].value;  

        var productElement = document.getElementById('product');
        productElement.options.length = 0;

        document.getElementById("price").value = "";
        document.getElementById("quantity").value = "";    
            
        if(selectedCategory == "") {
            return;    
        }

        var productArray = Object.keys(productsVal[selectedCategory]);
        createOption(productElement, " ---Choose Product --- ", "");

        for (i = 0; i < productArray.length; i++) {
            createOption(productElement, productsVal[selectedCategory][productArray[i]][0], productArray[i]);
        }
    }

    function createOption(ddl, text, value) {
        var opt = document.createElement('option');
        opt.value = value;
        opt.text = text;
        ddl.options.add(opt);
    }

    function displaydetails() {
        var categoryList = document.getElementById("category");  
        var selectedCategory = categoryList.options[categoryList.selectedIndex].value;  

        var productList = document.getElementById('product');
        var selectedProduct = productList.options[productList.selectedIndex].value;

        if(selectedProduct == "") {
            document.getElementById("price").value = "";
            document.getElementById("quantity").value = "";   
            return;
        }

        document.getElementById("productid").value = selectedProduct;
        document.getElementById("productname").value = productList.options[productList.selectedIndex].text;
        document.getElementById("price").value = productsVal[selectedCategory][[selectedProduct]][1];
        document.getElementById("quantity").value = productsVal[selectedCategory][[selectedProduct]][2];
    }
