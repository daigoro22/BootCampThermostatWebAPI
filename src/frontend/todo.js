
let baseUrl = 'localhost:8080/api/v1/todo'

fetch(baseUrl,{
    method:'GET',
    headers:{
        'Content-type':'application/json',
    },
})
.then(response=>console.log(response.json()))
.then(data=>{
    console.log('Success:',data);
})
.catch((error)=>{
    console.error('Error:',error);
});