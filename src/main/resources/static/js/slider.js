var prev = document.getElementById('btn-prev'),
    next = document.getElementById('btn-next'),
    slides = document.querySelectorAll('.slide'),
    dots = document.querySelectorAll('.dot');

let index =0;

function activeSlide(n){
    for(slide of slides){
        slide.classList.remove('active');
    }
    slides[n].classList.add('active');
}
function activeDot(n){
    for(dot of dots){
        dot.classList.remove('active');
    }
    dots[n].classList.add('active');
}

function prepare(ind){
    activeSlide(index);
    activeDot(index);
}

function nextSlide(){
    if (index == slides.length -1){
        index = 0;
        prepare(index);
    }else{
        index++;
        prepare(index);
    }
}
function prevSlide(){
    if (index == 0){
        index = slides.length -1;
        prepare(index);
    }else{
        index--;
        prepare(index);
    }
}

dots.forEach(function (item, indexDot){
    item.addEventListener('click', function (){
        index=indexDot;
        prepare(index);
    })
})
setInterval( nextSlide, 6000 );

next.addEventListener('click', nextSlide);
prev.addEventListener('click', prevSlide);