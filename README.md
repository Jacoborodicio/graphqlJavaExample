
Testing URL in local: http://localhost:8080/graphiql

Examples of queries used in graphiql:
```
# query ($id:Int){
#   getAllActors {
#     actorId
#     firstName
#     lastName
#     CUSTOM_KEY:address,
#     film {
#       name
#     }
#   }
  
#   getActorById(id:$id) {
#     actorId
#     firstName
#     lastName
#     address
#     film{
#       name
#       launchYear
#     }
#   }
# }

# Updating the address of the user with a certern id
# mutation ($id:Int) {
#   updateAddress(id:$id, address:"Ostuzzistrasse 2") {
#     firstName
#     lastName
#     address
#   }
# }

# # Showing Film data depending on a variable & showing the use of fragments
# query ($withFilm:Boolean!, $id:Int) {
#   getActorById(id:$id) {
#     ...actorDetails
#     dob,
#     film @include(if:$withFilm) {
#       name,
#       launchYear
#     }
#   }
# }

# Example updating with object
mutation ($input:AddressInput){
  updateAddressByObjectType(input:$input) {
    ...actorDetails
  }
}

# Fragment to spread some common used keys
fragment actorDetails on Actor {
  firstName
  lastName
  address
}
```
