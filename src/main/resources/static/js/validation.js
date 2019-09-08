function setInputFilter($textbox, inputFilter) {
    $textbox.on('input keydown keyup mousedown mouseup select contextmenu drop', function () {
        if (inputFilter(this.value)) {
            this.oldValue = this.value;
        } else if (this.hasOwnProperty('oldValue')) {
            this.value = this.oldValue;
        }
    });
}

function whatDecimalSeparator() {
    var lang = $('html').attr('lang');
    return 1.1.toLocaleString(lang).charAt(1);
}

$('.cr-double-number').each(function () {
    setInputFilter($(this), function (value) {
        var separator = whatDecimalSeparator();
        var re = new RegExp('^\\d*[' + separator + ']?\\d*$');
        return re.test(value);
    });
});