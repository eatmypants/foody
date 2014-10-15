<?php

/*
 * Following code will get single restorant details
 * A restaurant is identified by rest id (rest_id)
 */

// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';

// connecting to db
$db = new DB_CONNECT();

// check for post data
if (isset($_GET["rest_id"])) {
    $rid = $_GET['rest_id'];
	
	
	


    // get a restaurant from products table
    $result = mysql_query("SELECT restaurant.rest_id, restaurant.cui_id, restaurant.name, restaurant.location, restaurant.description, restaurant.avg_price, restaurant.link, restaurant_image.main_image_url FROM restaurant INNER JOIN restaurant_image ON restaurant.rest_id = restaurant_image.rest_id  WHERE restaurant.rest_id = $rid");

    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {

            $result = mysql_fetch_array($result);

            $restaurant = array();
            $restaurant["rest_id"] = $result["rest_id"];
            $restaurant["name"] = $result["name"];
            $restaurant["avg_price"] = $result["avg_price"];
            $restaurant["description"] = $result["description"];
           $restaurant["location"] = $result["location"];
            $restaurant["link"] = $result["link"];
			$restaurant["main_image_url"] = $result["main_image_url"];
    
     
            // success
            $response["success"] = 1;

            // user node
            $response["restaurant"] = array();

            array_push($response["restaurant"], $restaurant);

            // echoing JSON response
            echo json_encode($response);
        } else {
            // no product found
            $response["success"] = 0;
            $response["message"] = "No restaurant found";

            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no restaurant found
        $response["success"] = 0;
        $response["message"] = "No restaurant found";

        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
}
?>