/**
 * 
 */

console.log("Reply Module");
var replyService = (function() {
    var add = function(reply, callback, error) {
        console.log("add()....");
        $.ajax({
            url:"/replies/new",
            type:"post",
            data:JSON.stringify(reply),
            dataType:"json",
            contentType:"application/json; charset=utf-8",
            success : function(result, satatus, xhr) {
                if(callback) callback(result);
            },
            error : function(xhr, status, er) {
                if(error) error(er);
            }
        })
    }
    var getList = function(param, callback, error) {
        var bno = param.bno;
        var lastRno = param.lastRno || 0;
        var amount = param.amount || 10;

        console.log("getList()....");
        var url = "/replies/" + bno + "/" + lastRno + "/" + amount
        $.ajax({
            url:url,
            type:"get",
            dataType:"json",
            contentType:"application/json; charset=utf-8",
            success : function(result, satatus, xhr) {
                if(callback) callback(result);
            },
            error : function(xhr, status, er) {
                if(error) error(er);
            }
        })
    }
    var remove = () => {
        console.log("remove()....");
    }
    var update = function() {
        console.log("update()....");
    }
    var get = function() {
        console.log("get()....");
    }
    function displayTime() {
        console.log("displayTime()....")
    }

    return {
        add : add,
        getList : getList,
        remove : remove,
        get : get,
        update : update,
        displayTime : displayTime
    };
})();

console.log(replyService);
replyService.add();
replyService.getList();
replyService.remove();
replyService.get();
replyService.update();
replyService.displayTime();