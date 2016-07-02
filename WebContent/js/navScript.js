// JavaScript Document
function Navigate(url)
{
   parent.frames["mainFrame"].location = url;
}
function openWindow(url, title, width, height)
{
   var w = (screen.width - width) / 2;
   var h = (screen.height - height) / 2;
   window.open(url, title, "height=" + height + ",width=" + width + ", top=" + h + ", left=" + w + ", toolbar=no, menubar=no, status=yes,scrollbars=yes, resizable=no,location=no, status=no");
}
function ClientSide_ItemSelected(item)
{
   var nowLocation = item.GetProperty('Text');
   if(null != item.ParentItem)
   {
      nowLocation = item.ParentItem.GetProperty('Text') + '>>' + nowLocation;
   }
   if(null != item.ParentItem && null != item.ParentItem.ParentItem)
   {
      nowLocation = item.ParentItem.ParentItem.GetProperty('Text') + '>>' + nowLocation;
   }
   nowLocation = '当前配置>>' + nowLocation;
   parent.frames["application"].document.getElementById('application_titlebar_right').innerText = nowLocation;
   var navigate = item.GetProperty('ClientSideCommand');
   if(null != navigate && navigate.length > 0)
   
   {
      eval(navigate);
   }
}
