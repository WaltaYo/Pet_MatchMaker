var delayToShowInSeconds = 2;
var delayToHideGifImageInSeconds = 5;
setTimeout(function() {
    document.getElementById('hiddenText2').style.display = 'block';
    setTimeout(function() {
        document.getElementById('gifImage').style.display = 'none';
        document.getElementById('hiddenText2').style.display = 'none';
        document.getElementById('hiddenText').style.display = 'block';
        document.getElementById('hiddenText3').style.display = 'block';
    }, delayToHideGifImageInSeconds * 1000);
    
}, delayToShowInSeconds * 1000);
