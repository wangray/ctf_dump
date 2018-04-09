.class public Landroid/support/v7/widget/aw;
.super Landroid/support/v4/i/b;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/widget/aw$a;
    }
.end annotation


# instance fields
.field final a:Landroid/support/v7/widget/av;

.field final c:Landroid/support/v4/i/b;


# direct methods
.method public constructor <init>(Landroid/support/v7/widget/av;)V
    .locals 1

    invoke-direct {p0}, Landroid/support/v4/i/b;-><init>()V

    iput-object p1, p0, Landroid/support/v7/widget/aw;->a:Landroid/support/v7/widget/av;

    new-instance v0, Landroid/support/v7/widget/aw$a;

    invoke-direct {v0, p0}, Landroid/support/v7/widget/aw$a;-><init>(Landroid/support/v7/widget/aw;)V

    iput-object v0, p0, Landroid/support/v7/widget/aw;->c:Landroid/support/v4/i/b;

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;Landroid/support/v4/i/a/b;)V
    .locals 1

    invoke-super {p0, p1, p2}, Landroid/support/v4/i/b;->a(Landroid/view/View;Landroid/support/v4/i/a/b;)V

    const-class v0, Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/support/v4/i/a/b;->a(Ljava/lang/CharSequence;)V

    invoke-virtual {p0}, Landroid/support/v7/widget/aw;->b()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/aw;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getLayoutManager()Landroid/support/v7/widget/av$h;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/aw;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getLayoutManager()Landroid/support/v7/widget/av$h;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/support/v7/widget/av$h;->a(Landroid/support/v4/i/a/b;)V

    :cond_0
    return-void
.end method

.method public a(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1

    invoke-super {p0, p1, p2}, Landroid/support/v4/i/b;->a(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V

    const-class v0, Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    instance-of v0, p1, Landroid/support/v7/widget/av;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Landroid/support/v7/widget/aw;->b()Z

    move-result v0

    if-nez v0, :cond_0

    check-cast p1, Landroid/support/v7/widget/av;

    invoke-virtual {p1}, Landroid/support/v7/widget/av;->getLayoutManager()Landroid/support/v7/widget/av$h;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Landroid/support/v7/widget/av;->getLayoutManager()Landroid/support/v7/widget/av$h;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/support/v7/widget/av$h;->a(Landroid/view/accessibility/AccessibilityEvent;)V

    :cond_0
    return-void
.end method

.method public a(Landroid/view/View;ILandroid/os/Bundle;)Z
    .locals 1

    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/i/b;->a(Landroid/view/View;ILandroid/os/Bundle;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/widget/aw;->b()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/aw;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getLayoutManager()Landroid/support/v7/widget/av$h;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/aw;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getLayoutManager()Landroid/support/v7/widget/av$h;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Landroid/support/v7/widget/av$h;->a(ILandroid/os/Bundle;)Z

    move-result v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method b()Z
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/aw;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->w()Z

    move-result v0

    return v0
.end method

.method public c()Landroid/support/v4/i/b;
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/aw;->c:Landroid/support/v4/i/b;

    return-object v0
.end method
