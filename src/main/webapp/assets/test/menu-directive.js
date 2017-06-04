/**
 * index menu
 *
 * Created by wangjianan on 17-6-3.
 */
$(document).ready(function(){
    $(document).on('click', '[data-toggle^="class"]', function (e) {
        var $class = $(this).data()['toggle'];
        var $target = $(this).data()['target'];

        var $temp = $class.split(':')[1];
        var $root = document.getElementById($target);
        var isTrue = $root.classList.contains($temp);
        
        if (isTrue) {
            $root.classList.remove($temp);
        } else {
            $root.classList.add($temp);
        }
    });
});