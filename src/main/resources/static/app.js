
const url = 'http://localhost:8080/api/v1/albums';

const getAlbums = function (){
    fetch(url).then(function (resp){
        return resp.json();
    })
        .then(function (data){
            console.log(data);
        })
}

const getAlbum = function (id){
    fetch(url + `/${id}`).then(function (resp){
        return resp.json();
    })
        .then(function (data){
            console.log(data);
        })
}

getAlbums();
getAlbum(2);
