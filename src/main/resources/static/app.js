const url = 'http://localhost:8080/api/v1/albums';

const getAlbums = function () {
    fetch(url).then(function (resp) {
        return resp.json();
    })
        .then(function (data) {
            console.log(data);
        })
}

const getAlbum = function (id) {
    fetch(url + `/${id}`).then(function (resp) {
        if (!resp.ok) {
            throw new Error(`Nie znaleziono albumu (${resp.status})`);
        }
        return resp.json();
    })
        .then(function (data) {
            console.log(data);
        })
}

const addAlbum = {
    id: 5, title: 'Parsley', releasedDate: '2016-04-15', region: 'Poland'
}

fetch(url, {
    method: 'POST', mode: 'cors', body: JSON.stringify(
        addAlbum
    ), headers: {
        'Content-Type': 'application/json'
    }
})
    .then((resp) => resp.json())

getAlbums();
getAlbum(2);
getAlbum(5);


