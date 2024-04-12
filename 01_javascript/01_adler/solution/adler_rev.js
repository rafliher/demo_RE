cipher = "DàİŶƻȎɢʓˈ̓͸ϚлѯҧӝՀո֩؍قٶگܒݴޭߣࠗࡼࢰऒॆॻমৢੈભଐୄ୵ப௟ు౳೔ആഺ൬ිชฺຝ໔༈ཫྡဃံၧႝᄃᄹᅱᆤሊቁእዖገጽ᎟᐀ᐳᑩᓦD×ųȐʦ̱ωѰӵ՛؋ڻݒࠕࢪख঄ਝસଡஶ౏ಸഥශຆ༡ྐ࿺႓ᄬᇂቘ዁ጩ᎐ᐪᓵᖽᙔᚹᜟញᠠᢴ᥇᧚ᩀ᪦ᬾᯜ᱄᳗ᵱᷜṳἌᾤ‹₝℄↠∼⊪⌕⎮⑋ⓦ╻◞♅⛜➟⠳⢜⥏"
enc = []
cipher.split("").map((char, index) => {
    enc[index] = char.charCodeAt(0)
});
const middleIndex = Math.floor(enc.length / 2);

holder1 = enc.slice(0, middleIndex);
holder2 = enc.slice(middleIndex);

fl4g = []
holder1.map((ord, index) => {
    !index ? fl4g[index] = String.fromCharCode(holder1[index]-1) : fl4g[index] = String.fromCharCode(holder1[index] - holder1[index-1])
});
fl4g = fl4g.join("")