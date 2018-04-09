.class public Landroid/support/v7/widget/aw$a;
.super Landroid/support/v4/i/b;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/aw;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation


# instance fields
.field final a:Landroid/support/v7/widget/aw;


# direct methods
.method public constructor <init>(Landroid/support/v7/widget/aw;)V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/i/b;-><init>()V

    iput-object p1, p0, Landroid/support/v7/widget/aw$a;->a:Landroid/support/v7/widget/aw;

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;Landroid/support/v4/i/a/b;)V
    .locals 1

    invoke-super {p0, p1, p2}, Landroid/support/v4/i/b;->a(Landroid/view/View;Landroid/support/v4/i/a/b;)V

    iget-object v0, p0, Landroid/support/v7/widget/aw$a;->a:Landroid/support/v7/widget/aw;

    invoke-virtual {v0}, Landroid/support/v7/widget/aw;->b()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/aw$a;->a:Landroid/support/v7/widget/aw;

    iget-object v0, v0, Landroid/support/v7/widget/aw;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getLayoutManager()Landroid/support/v7/widget/av$h;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/aw$a;->a:Landroid/support/v7/widget/aw;

    iget-object v0, v0, Landroid/support/v7/widget/aw;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getLayoutManager()Landroid/support/v7/widget/av$h;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Landroid/support/v7/widget/av$h;->a(Landroid/view/View;Landroid/support/v4/i/a/b;)V

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
    iget-object v0, p0, Landroid/support/v7/widget/aw$a;->a:Landroid/support/v7/widget/aw;

    invoke-virtual {v0}, Landroid/support/v7/widget/aw;->b()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/aw$a;->a:Landroid/support/v7/widget/aw;

    iget-object v0, v0, Landroid/support/v7/widget/aw;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getLayoutManager()Landroid/support/v7/widget/av$h;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/aw$a;->a:Landroid/support/v7/widget/aw;

    iget-object v0, v0, Landroid/support/v7/widget/aw;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getLayoutManager()Landroid/support/v7/widget/av$h;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v7/widget/av$h;->a(Landroid/view/View;ILandroid/os/Bundle;)Z

    move-result v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
