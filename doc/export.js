hljs.configure({
  tabReplace: '  '
})
hljs.initHighlighting();

$(document).ready(function() {
  $('pre.src').each(function(i, block) {
    hljs.highlightBlock(block);
  });
});
console.log(" foo bar");
