# CSS

## Change mouse's status
```
cursor: pointer; 
cursor: hand;
```
The cursor render as a pointer (a hand) that indicates a link

```
cursor: wait;
```
The cursor indicates that the program is busy (often a watch or an hourglass)

```
cursor: help;
```
The cursor indicates that help is available (often a question mark or a balloon)

```
cursor: no-drop;
```

```
cursor: text;
```

The cursor indicates text

## Bootstrap Popover
`<button type="button" class="btn btn-lg btn-danger" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?">Click to toggle popover</button>`

Remember to use JavaScript to activate this!
`$('#example').popover(options)`

- Dismiss on next click
For proper cross-browser and cross-platform behavior, you must use the `<a>` tag, not the `<button>` tag, and you also must include a `tabindex` attribute.

CSS:
`<a tabindex="0" class="btn btn-lg btn-danger" role="button" data-toggle="popover" data-trigger="focus" title="Dismissible popover" data-content="And here's some amazing content. It's very engaging. Right?">Dismissible popover</a>`

JAVASCIRPT:
```
$('.popover-dismiss').popover({
  trigger: 'focus'
})
```

## Definition of height/padding/...

## Boostrap Form
Bootstrap provides three types of form layouts:

- Vertical form (this is default)
- Horizontal form
- Inline form
Standard rules for all three form layouts:

Wrap labels and form controls in `<div class="form-group">` (needed for optimum spacing)
Add class .form-control to all textual `<input>`, `<textarea>`, and `<select>` elements


