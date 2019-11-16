var $select1 = $('#select1'),
    $select2 = $('#select2'),
    $options = $select2.find('option');

$select1.on('change', function () {
    $select2.html($options.filter('[value="' + this.value + '"]'));
}).trigger('change');