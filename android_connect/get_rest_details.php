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
    $result = mysql_query("SELECT *FROM restaurants WHERE rest_id = $rid");

    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {

            $result = mysql_fetch_array($result);

            $restaurant = array();
            $restaurant["rest_id"] = $result["rest_id"];
            $restaurant["name"] = $result["name"];
            $restaurant["avg_price"] = $result["avg_price"];
            $restaurant["description"] = $result["description"];
            $restaurant["cuisine"] = $result["cuisine"];
     
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