<?php

/*
 * Following code will list all the restaurant
 */

// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';

// connecting to db
$db = new DB_CONNECT();

// get all restaurant from restaurant table
$result = mysql_query("SELECT *FROM restaurants") or die(mysql_error());

// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // restaurant node
    $response["restaurant"] = array();
    
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $restaurant = array();
        $restaurant["rest_id"] = $row["rest_id"];
        $restaurant["name"] = $row["name"];
        $restaurant["avg_price"] = $row["avg_price"];
        $restaurant["description"] = $row["description"];
        $restaurant["cuisine"] = $row["cuisine"];
      



        // push single restorant into final response array
        array_push($response["restaurant"], $restaurant);
    }
    // success
    $response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
} else {
    // no restaurant found
    $response["success"] = 0;
    $response["message"] = "No restaurant found";

    // echo no users JSON
    echo json_encode($response);
}
?>
