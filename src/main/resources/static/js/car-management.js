function initializeDeleteCar(){

    function initDeleteCar(deleteCarBtn){
        $(deleteCarBtn).on('click', function(){
            var url = $(deleteCarBtn).data('url');
            $.post(url).done(function(){
                $(deleteCarBtn).closest('.car-card').remove();
            })
        })
    }

    $('.delete-car-btn').each(function(index, deleteCarBtn) {
        initDeleteCar(deleteCarBtn);
    })
}

$(initializeDeleteCar);