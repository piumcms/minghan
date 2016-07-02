//top
$(function() {
    $(window).scroll(function() {
        if ($(window).scrollTop() > 45) {
            $('.header').slideUp(300).siblings('.header_top2').slideDown(500);
        }
        else {
            $('.header').slideDown(300).siblings('.header_top2').slideUp(500);
        }
    })
})
//nav



$(function() {
    $('.nav li.last dl.subnav2 dd:odd').css('margin-right', '0');
})
$(function() {
    $('.nav li').hover(function() {
        $(this).children('a.first_nav').addClass('cur').siblings('.subnav').stop().show();
        $(this).children('a.first_nav').addClass('cur').siblings('dl.subnav2').stop().show()
    }, function() {
        $(this).children('a.first_nav').removeClass('cur').siblings('.subnav').stop().hide();
        $(this).children('a.first_nav').removeClass('cur').siblings('dl.subnav2').stop().hide()
    });
    $(".last").hover(function() {
        $(this).find(".subnav2").hide();
    });
})


//index banner 20140523 start
$(function() {
    $('.banner').hover(function() {
        $('span.left').show().siblings('span.right').show();
    }, function() {
        $('span.left').hide().siblings('span.right').hide();
    })
})

$(function() {
    var bannerli = $('.banner_box li');
    var bannerbtn = $('.slide_dot span');
    var prevbtn = $('.banner>span.left');
    var nextbtn = $('.banner>span.right');
    var now = 0, next = 1;
    var timer = null;
    var biaozhi = false;
    var timer = setTimeout(play, 1000);

    prevbtn.click(function() {
        if (biaozhi) {
            return false;
        }
        clearTimeout(timer);
        next = now - 1 < 0 ? bannerli.length - 1 : now - 1;
        play();
    });

    nextbtn.click(function() {
        if (biaozhi) {
            return false;
        }
        clearTimeout(timer);
        next = now + 1 >= bannerli.length ? 0 : now + 1;
        play();
    });

    bannerbtn.click(function() {
        if (biaozhi) {
            return false;
        }
        clearTimeout(timer);
        next = $(this).index();
        play();
    });

    function play() {
        biaozhi = true;
        var maxn = bannerli.eq(now).find('p img').length - 1;
        bannerbtn.eq(next).addClass('active').siblings().removeClass('active');
        bannerli.find('p img').css('left', '0%')
        bannerli.eq(now).find('p img').each(function(index, element) {
            $(this).delay(index * 1000).animate({ left: '-100%' }, 800, 'easeInExpo');
            if (index == maxn) {
                setTimeout(function() {
                    bannerli.eq(now).animate({ left: '-100%' }, 1000);
                    bannerli.eq(next).css('left', '100%').animate({ left: '0%' }, 1000, function() {
                        now = next;
                        next = next + 1 >= bannerli.length ? 0 : next + 1;
                        biaozhi = false;
                        timer = setTimeout(play, 5000);
                    });
                }, 1000);
            }
        });
    }
})
//20140523 end

//vieo
$(function() {
    var nowIndex = 0;
    var imgList = $('.video ul li');
    var aBtn = $('.slide_num span');
    imgList.hide().eq(nowIndex).fadeIn('slow');
    aBtn.eq(nowIndex).addClass('active');
    function hideShow() {
        imgList.eq(nowIndex).fadeIn('slow').siblings().fadeOut('slow');
        aBtn.eq(nowIndex).addClass('active').siblings().removeClass('active');
    }
    function next() {
        if (nowIndex > imgList.length - 1)
        { nowIndex = 0; }
        else if (nowIndex < 0) { nowIndex = imgList.length - 1; }
        hideShow();
    }
    function autoPlay() {
        nowIndex++;
        next();
    }
    var timer = setInterval(autoPlay, 3000);
    aBtn.click(function() {
        clearInterval(timer);
        nowIndex = $(this).index();
        hideShow();
        timer = setInterval(autoPlay, 3000);
        return false;
    })
})
//download
$(function() {
    $('.download_list li').click(function() {
        $(this).children('.name').addClass('name_active');
        $(this).siblings().children('.name').removeClass('name_active');
        $(this).children('.download_des').slideDown(300).parent().siblings().children('.download_des').slideUp(300);
    })
})
//right_animate
$(function() {
    var nowIndex = 0;
    var imgList = $('.right_animate ul li');
    var aBtn = $('.dot_list span');
    imgList.hide().eq(nowIndex).fadeIn('slow');
    aBtn.eq(nowIndex).addClass('active');
    function hideShow() {
        imgList.eq(nowIndex).fadeIn('slow').siblings().fadeOut('slow');
        aBtn.eq(nowIndex).addClass('active').siblings().removeClass('active');
    }
    function next() {
        if (nowIndex > imgList.length - 1)
        { nowIndex = 0; }
        else if (nowIndex < 0) { nowIndex = imgList.length - 1; }
        hideShow();
    }
    function autoPlay() {
        nowIndex++;
        next();
    }
    var timer = setInterval(autoPlay, 3000);
    aBtn.click(function() {
        clearInterval(timer);
        nowIndex = $(this).index();
        hideShow();
        timer = setInterval(autoPlay, 3000);
        return false;
    })
})



//commercial why tdg solar
$(function() {
    $('.commercial_solar li:odd').css('background', '#f8f8f8')
})

//commercial Portfolio
$(function() {
    var nowIndex = 0;
    var imgList = $('.portfolio ul li');
    var aBtn = $('.portfolio_dot span');
    imgList.hide().eq(nowIndex).fadeIn('slow');
    aBtn.eq(nowIndex).addClass('active');
    function hideShow() {
        imgList.eq(nowIndex).fadeIn('slow').siblings().fadeOut('slow');
        aBtn.eq(nowIndex).addClass('active').siblings().removeClass('active');
    }
    function next() {
        if (nowIndex > imgList.length - 1)
        { nowIndex = 0; }
        else if (nowIndex < 0) { nowIndex = imgList.length - 1; }
        hideShow();
    }
    function autoPlay() {
        nowIndex++;
        next();
    }
    var timer = setInterval(autoPlay, 3000);
    aBtn.click(function() {
        clearInterval(timer);
        nowIndex = $(this).index();
        hideShow();
        timer = setInterval(autoPlay, 3000);
        return false;
    })
})
//commercial Portfolio show
$(function() {
    var nowIndex = 0;
    var imgList = $('.show_r_animate ul li');
    var aBtn = $('.show_slide span');
    imgList.hide().eq(nowIndex).fadeIn('slow');
    aBtn.eq(nowIndex).addClass('active');
    function hideShow() {
        if (nowIndex > -1) {
            imgList.eq(nowIndex).fadeIn('slow').siblings().fadeOut('slow');
            aBtn.eq(nowIndex).addClass('active').siblings().removeClass('active');
        }
    }
    function next() {
        if (nowIndex > imgList.length - 1)
        { nowIndex = 0; }
        else if (nowIndex < 0) { nowIndex = imgList.length - 1; }
        hideShow();
    }
    function autoPlay() {
        nowIndex++;
        next();
    }
    var timer = setInterval(autoPlay, 3000);
    aBtn.click(function() {
        clearInterval(timer);
        nowIndex = $(this).index();
        hideShow();
        timer = setInterval(autoPlay, 3000);
        return false;
    })
    $("span.left_icon").click(function() {
        clearInterval(timer);
        nowIndex = $(".show_r_animate .show_slide span").index($(".show_slide .active"));
        nowIndex--;
        hideShow();
        timer = setInterval(autoPlay, 3000);
        return false;
    });
    $("span.right_icon").click(function() {
        clearInterval(timer);
        nowIndex = $(".show_r_animate .show_slide span").index($(".show_slide .active"));
        nowIndex++;
        hideShow();
        timer = setInterval(autoPlay, 3000);
        return false;
    })
})
//history
$(function() {
    var nowIndex = 0;
    var imgList = $('.history_content .item');
    var aBtn = $('.history_time_slide ul li');
    imgList.hide().eq(nowIndex).show('slow');
    aBtn.eq(nowIndex).addClass('active');
    function hideShow() {
        if (nowIndex > -1) {
            imgList.eq(nowIndex).show().siblings().hide();
            aBtn.eq(nowIndex).addClass('active').siblings().removeClass('active');
        }

        if ((nowIndex * 84 - 650) + parseInt($(".history_time_slide .c").css("marginLeft").replace("px", "")) > 0 && nowIndex < imgList.length)
            $(".history_time_slide .c").animate({ marginLeft: "-=84px" }, 1000);

        if ((nowIndex * 84 - 650) + parseInt($(".history_time_slide .c").css("marginLeft").replace("px", "")) < -650 && nowIndex >= 0)
            $(".history_time_slide .c").animate({ marginLeft: "+=84px" }, 1000);
    }
    function next() {
        if (nowIndex > imgList.length - 1)
        { nowIndex = 0; }
        else if (nowIndex < 0) { nowIndex = imgList.length - 1; }
        hideShow();
    }

    aBtn.click(function() {
        nowIndex = $(this).index();
        hideShow();
        return false;
    })
    $(".history_time span.left").click(function() {
        nowIndex = $(".history_time_slide ul li").index($(".active"));
        nowIndex--;
        hideShow();
        return false;
    });
    $(".history_time span.right").click(function() {
        nowIndex = $(".history_time_slide ul li").index($(".active"));
        nowIndex++;
        hideShow();
        return false;
    })
})



//contact
$(function() {
    $('.contact .add_one span,.contact .add_two span,.contact .add_three span,.contact .add_four span').hover(function() {
        $(this).siblings('.add_one_main').stop().show();
    });
    $('.contact .add_one .add_one_main,.contact .add_two .add_one_main,.contact .add_three .add_one_main,.contact .add_four .add_one_main').hover(function() {
        $(this).stop().show();
    });
    $('.contact .add_one,.contact .add_two,.contact .add_three,.contact .add_four').hover(function() { }, function() {
        $(this).children('.add_one_main').hide();
    })



})
//选项卡
$(function() {
    $('.choose_box .item').eq(0).show().siblings().hide();
    $('.products_choose span').click(function() {
      //  $(this).addClass('cur').siblings().removeClass('cur');
        var index = $(this).index()
        $('.choose_box .item').eq(index).show().siblings().hide();
    })
})
//小图变大图
$(function() {
    var nowIndex = 0;
    var imgList = $('.choose_left ul li');
    var aBtn = $('.choose_small_box ul li');
    imgList.hide().eq(nowIndex).fadeIn('slow');
    aBtn.eq(nowIndex).addClass('active');
    function hideShow() {
        if (nowIndex > -1) {
            imgList.eq(nowIndex).fadeIn('slow').siblings().fadeOut('slow');
            aBtn.eq(nowIndex).addClass('active').siblings().removeClass('active');
        }
    }
    function next() {
        if (nowIndex > imgList.length - 1)
        { nowIndex = 0; }
        else if (nowIndex < 0) { nowIndex = imgList.length - 1; }
        hideShow();
    }
    function autoPlay() {
        nowIndex++;
        next();
    }
    var timer = setInterval(autoPlay, 3000);
    aBtn.click(function() {
        clearInterval(timer);
        nowIndex = $(this).index();
        hideShow();
        timer = setInterval(autoPlay, 3000);
        return false;
    })
    $("span.jiantou_left").click(function() {
        nowIndex = $(".choose_small_box ul li").index($(".active"));
        nowIndex--;
        hideShow();
        return false;
    });
    $("span.jiantou_right").click(function() {
        nowIndex = $(".choose_small_box ul li").index($(".active"));
        nowIndex++;
        hideShow();
        return false;
    })
})


//products

$(function() {
    $('.like ul li').hover(function() {
        $(this).children('.li_hover').show().parent().siblings().children('.li_hover').hide();
    }, function() {
        $(this).children('.li_hover').show();
    })
})

//zy_download
$(function() {
    $(".zy_down_list p").click(function() {
        $(this).next('div').slideDown('slow').siblings('div').slideUp('slow')

    })

})
//lst_js
$(document).ready(function() {


    /***********************************dealer***********************/

    $(".lst_dealer_formtitle a").hover(function() {
        var i = $(this).index();
        var nLength = $(".lst_dealer_formtitle a").length;
        if (i == nLength - 1) {
            $(this).addClass("lst_dealer_alasthover");
        } else if (i != 0) {
            $(this).addClass("lst_dealer_ahover");
        }
    }, function() {
        $(this).removeClass("lst_dealer_alasthover");
        $(this).removeClass("lst_dealer_ahover");
    })

    /*****************************victoria*********************/

    $(".lst_victoria_nav>span").mouseover(function() {
        var nIndex = $(this).index();
        $(".lst_victoria_text").eq(nIndex).siblings(".lst_victoria_text").hide().end().show();
        $(this).siblings(".lst_victoria_nav>span").removeClass("lst_victoria_navhover").end().addClass("lst_victoria_navhover");
    })


    /***********************testimonial*********************/

    var textscroll = $(".lst_testimonials_scroll ul");
    var testbtn = $(".lst_testimonials_scroll span");
    var nLength = textscroll.children("li").length - 3;
    var nCount = 0;
    testbtn.click(function() {

        var nIndex = $(this).index();
        switch (nIndex) {
            case 1:
                if (nLength > 0) {
                    textscroll.animate({ left: "-=219px" }, 1000);
                    nLength--;
                    nCount++;
                }
                break;
            case 0:
                if (nCount > 0) {
                    textscroll.animate({ left: "+=219px" }, 1000);
                    nLength++;
                    nCount--;
                }
                break;
        }
    })


    /**********************************solar**************************/
    $(".lst_solar_li:odd").css("background", "#f8f8f8");
    $(".lst_solar_li>dl>dt:odd").css("background-image", "url(images/lst_Residential_solar_10.jpg)");

    /***************2013-8-23*******************/
    //	    $('.zy_video_left,.zy_video_list li').click(function() {
    //	        $('.tanchu').show();
    //	    })

    //	    $(".bideo_as li").click(function() {
    //	        $('.tanchu').eq($(this).index()).show();
    //	    });

    //	    $('.tanchu p.close a').click(function() {
    //	        $('.tanchu').hide();
    //	    })


    //	})


    /***************2013-8-23*******************/
    $('.zy_video_left').click(function() {
        $('.tanchu').eq(0).show();
    })

    $('.tanchu p.close a').click(function() {
        $('.tanchu').hide();
    })
    $('.zy_video_list li').click(function() {
        $('.tanchu').eq($(this).index() + 1).show();
    })
    $('.tanchu p.close a').click(function() {
        $('.tanchu').hide();
    })
    $('.bideo_as li').click(function() {
        $('.tanchu').eq($(this).index() + 5).show();
    })
    $('.tanchu p.close a').click(function() {
        $('.tanchu').hide();
    })




    $('.video ul li .li3 a img').click(function() {


        var idString = 'tanchu' + $(this).attr("id");

        $("#" + idString).show();


    })
    $('.tanchu p.close a').click(function() {
        $('.tanchu').eq(2).hide();

    })


})



/*20140523 start*/
$(function() {
    (function() {
        $('.lst_dealer_formtitle>a').click(function() {
            $(this).addClass('add_dealer_active').siblings().removeClass('add_dealer_active');
            $('.add_dealer_choose .item').eq($(this).index()).show().siblings().hide();
        })
    })();
})

/************easeing***************/

jQuery.easing['jswing'] = jQuery.easing['swing'];

jQuery.extend(jQuery.easing,
{
    def: 'easeOutQuad',
    swing: function(x, t, b, c, d) {
        //alert(jQuery.easing.default);
        return jQuery.easing[jQuery.easing.def](x, t, b, c, d);
    },
    easeInQuad: function(x, t, b, c, d) {
        return c * (t /= d) * t + b;
    },
    easeOutQuad: function(x, t, b, c, d) {
        return -c * (t /= d) * (t - 2) + b;
    },
    easeInOutQuad: function(x, t, b, c, d) {
        if ((t /= d / 2) < 1) return c / 2 * t * t + b;
        return -c / 2 * ((--t) * (t - 2) - 1) + b;
    },
    easeInCubic: function(x, t, b, c, d) {
        return c * (t /= d) * t * t + b;
    },
    easeOutCubic: function(x, t, b, c, d) {
        return c * ((t = t / d - 1) * t * t + 1) + b;
    },
    easeInOutCubic: function(x, t, b, c, d) {
        if ((t /= d / 2) < 1) return c / 2 * t * t * t + b;
        return c / 2 * ((t -= 2) * t * t + 2) + b;
    },
    easeInQuart: function(x, t, b, c, d) {
        return c * (t /= d) * t * t * t + b;
    },
    easeOutQuart: function(x, t, b, c, d) {
        return -c * ((t = t / d - 1) * t * t * t - 1) + b;
    },
    easeInOutQuart: function(x, t, b, c, d) {
        if ((t /= d / 2) < 1) return c / 2 * t * t * t * t + b;
        return -c / 2 * ((t -= 2) * t * t * t - 2) + b;
    },
    easeInQuint: function(x, t, b, c, d) {
        return c * (t /= d) * t * t * t * t + b;
    },
    easeOutQuint: function(x, t, b, c, d) {
        return c * ((t = t / d - 1) * t * t * t * t + 1) + b;
    },
    easeInOutQuint: function(x, t, b, c, d) {
        if ((t /= d / 2) < 1) return c / 2 * t * t * t * t * t + b;
        return c / 2 * ((t -= 2) * t * t * t * t + 2) + b;
    },
    easeInSine: function(x, t, b, c, d) {
        return -c * Math.cos(t / d * (Math.PI / 2)) + c + b;
    },
    easeOutSine: function(x, t, b, c, d) {
        return c * Math.sin(t / d * (Math.PI / 2)) + b;
    },
    easeInOutSine: function(x, t, b, c, d) {
        return -c / 2 * (Math.cos(Math.PI * t / d) - 1) + b;
    },
    easeInExpo: function(x, t, b, c, d) {
        return (t == 0) ? b : c * Math.pow(2, 10 * (t / d - 1)) + b;
    },
    easeOutExpo: function(x, t, b, c, d) {
        return (t == d) ? b + c : c * (-Math.pow(2, -10 * t / d) + 1) + b;
    },
    easeInOutExpo: function(x, t, b, c, d) {
        if (t == 0) return b;
        if (t == d) return b + c;
        if ((t /= d / 2) < 1) return c / 2 * Math.pow(2, 10 * (t - 1)) + b;
        return c / 2 * (-Math.pow(2, -10 * --t) + 2) + b;
    },
    easeInCirc: function(x, t, b, c, d) {
        return -c * (Math.sqrt(1 - (t /= d) * t) - 1) + b;
    },
    easeOutCirc: function(x, t, b, c, d) {
        return c * Math.sqrt(1 - (t = t / d - 1) * t) + b;
    },
    easeInOutCirc: function(x, t, b, c, d) {
        if ((t /= d / 2) < 1) return -c / 2 * (Math.sqrt(1 - t * t) - 1) + b;
        return c / 2 * (Math.sqrt(1 - (t -= 2) * t) + 1) + b;
    },
    easeInElastic: function(x, t, b, c, d) {
        var s = 1.70158; var p = 0; var a = c;
        if (t == 0) return b; if ((t /= d) == 1) return b + c; if (!p) p = d * .3;
        if (a < Math.abs(c)) { a = c; var s = p / 4; }
        else var s = p / (2 * Math.PI) * Math.asin(c / a);
        return -(a * Math.pow(2, 10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p)) + b;
    },
    easeOutElastic: function(x, t, b, c, d) {
        var s = 1.70158; var p = 0; var a = c;
        if (t == 0) return b; if ((t /= d) == 1) return b + c; if (!p) p = d * .3;
        if (a < Math.abs(c)) { a = c; var s = p / 4; }
        else var s = p / (2 * Math.PI) * Math.asin(c / a);
        return a * Math.pow(2, -10 * t) * Math.sin((t * d - s) * (2 * Math.PI) / p) + c + b;
    },
    easeInOutElastic: function(x, t, b, c, d) {
        var s = 1.70158; var p = 0; var a = c;
        if (t == 0) return b; if ((t /= d / 2) == 2) return b + c; if (!p) p = d * (.3 * 1.5);
        if (a < Math.abs(c)) { a = c; var s = p / 4; }
        else var s = p / (2 * Math.PI) * Math.asin(c / a);
        if (t < 1) return -.5 * (a * Math.pow(2, 10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p)) + b;
        return a * Math.pow(2, -10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p) * .5 + c + b;
    },
    easeInBack: function(x, t, b, c, d, s) {
        if (s == undefined) s = 1.70158;
        return c * (t /= d) * t * ((s + 1) * t - s) + b;
    },
    easeOutBack: function(x, t, b, c, d, s) {
        if (s == undefined) s = 1.70158;
        return c * ((t = t / d - 1) * t * ((s + 1) * t + s) + 1) + b;
    },
    easeInOutBack: function(x, t, b, c, d, s) {
        if (s == undefined) s = 1.70158;
        if ((t /= d / 2) < 1) return c / 2 * (t * t * (((s *= (1.525)) + 1) * t - s)) + b;
        return c / 2 * ((t -= 2) * t * (((s *= (1.525)) + 1) * t + s) + 2) + b;
    },
    easeInBounce: function(x, t, b, c, d) {
        return c - jQuery.easing.easeOutBounce(x, d - t, 0, c, d) + b;
    },
    easeOutBounce: function(x, t, b, c, d) {
        if ((t /= d) < (1 / 2.75)) {
            return c * (7.5625 * t * t) + b;
        } else if (t < (2 / 2.75)) {
            return c * (7.5625 * (t -= (1.5 / 2.75)) * t + .75) + b;
        } else if (t < (2.5 / 2.75)) {
            return c * (7.5625 * (t -= (2.25 / 2.75)) * t + .9375) + b;
        } else {
            return c * (7.5625 * (t -= (2.625 / 2.75)) * t + .984375) + b;
        }
    },
    easeInOutBounce: function(x, t, b, c, d) {
        if (t < d / 2) return jQuery.easing.easeInBounce(x, t * 2, 0, c, d) * .5 + b;
        return jQuery.easing.easeOutBounce(x, t * 2 - d, 0, c, d) * .5 + c * .5 + b;
    }
});



$(function() {
    $(".more a").each(function() {
        $(this).attr("href", $(this).attr("href").toString().replace("<br />", ""))
    });
    
});