function initMap() {
    var map = new google.maps.Map(document.getElementById('hourlyRainChart'), {});
    var input = document.getElementById('searchInput');

    var autocomplete = new google.maps.places.Autocomplete(input);
    autocomplete.bindTo('bounds', map);

    autocomplete.addListener('place_changed', function() {
        var place = autocomplete.getPlace();
        if (!place.geometry) {
            window.alert("Autocomplete's returned place contains no geometry");
            return;
        }
        document.getElementById('searchName').value = place.formatted_address;
        document.getElementById('searchLat').value = place.geometry.location.lat();
        document.getElementById('searchLon').value = place.geometry.location.lng();
        document.getElementById('searchSubmit').click();
    });
}
