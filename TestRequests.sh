
# Add items
curl -X PUT http://localhost:8080/item/item -H 'Content-Type: application/json' -d '{
"id": 1,
"title": "item 1",
"desc": "this is item 1",
"imagePath": "//image-path",
"price": 12.0
}'

curl -X PUT http://localhost:8080/item/item -H 'Content-Type: application/json' -d '{
"id": 2,
"title": "item 2",
"desc": "this is item 2",
"imagePath": "//image-path-2",
"price": 14.0
}'

curl -X PUT http://localhost:8080/item/item -H 'Content-Type: application/json' -d '{
"id": 3,
"title": "item 3",
"desc": "this is item 3",
"imagePath": "//image-path-3",
"price": 42.0
}'

# Edit item 3
curl -X PUT http://localhost:8080/item/item -H 'Content-Type: application/json' -d '{
"id": 3,
"title": "item 3 edited",
"desc": "this is item 3, after editing :)",
"imagePath": "//image-path-3",
"price": 42.0
}'

# Delete item 2
curl -X DELETE http://localhost:8080/item/item -H 'Content-Type: application/json' -d '{
"id": 2
}'
