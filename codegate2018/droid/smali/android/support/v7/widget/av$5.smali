.class Landroid/support/v7/widget/av$5;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/support/v7/widget/ad$b;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/av;->A()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/av;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/av;)V
    .locals 0

    iput-object p1, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getChildCount()I

    move-result v0

    return v0
.end method

.method public a(Landroid/view/View;)I
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/av;->indexOfChild(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public a(I)V
    .locals 2

    iget-object v0, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/av;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/av;->k(Landroid/view/View;)V

    invoke-virtual {v0}, Landroid/view/View;->clearAnimation()V

    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/av;->removeViewAt(I)V

    return-void
.end method

.method public a(Landroid/view/View;I)V
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0, p1, p2}, Landroid/support/v7/widget/av;->addView(Landroid/view/View;I)V

    iget-object v0, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/av;->l(Landroid/view/View;)V

    return-void
.end method

.method public a(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V
    .locals 4

    invoke-static {p1}, Landroid/support/v7/widget/av;->e(Landroid/view/View;)Landroid/support/v7/widget/av$w;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->r()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->c()Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Called attach on a child which is not detached: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->m()V

    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-static {v0, p1, p2, p3}, Landroid/support/v7/widget/av;->a(Landroid/support/v7/widget/av;Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    return-void
.end method

.method public b(Landroid/view/View;)Landroid/support/v7/widget/av$w;
    .locals 1

    invoke-static {p1}, Landroid/support/v7/widget/av;->e(Landroid/view/View;)Landroid/support/v7/widget/av$w;

    move-result-object v0

    return-object v0
.end method

.method public b(I)Landroid/view/View;
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/av;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public b()V
    .locals 4

    invoke-virtual {p0}, Landroid/support/v7/widget/av$5;->a()I

    move-result v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_0

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/av$5;->b(I)Landroid/view/View;

    move-result-object v2

    iget-object v3, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v3, v2}, Landroid/support/v7/widget/av;->k(Landroid/view/View;)V

    invoke-virtual {v2}, Landroid/view/View;->clearAnimation()V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->removeAllViews()V

    return-void
.end method

.method public c(I)V
    .locals 4

    invoke-virtual {p0, p1}, Landroid/support/v7/widget/av$5;->b(I)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-static {v0}, Landroid/support/v7/widget/av;->e(Landroid/view/View;)Landroid/support/v7/widget/av$w;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->r()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->c()Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "called detach on an already detached child "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_0
    const/16 v1, 0x100

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/av$w;->b(I)V

    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-static {v0, p1}, Landroid/support/v7/widget/av;->a(Landroid/support/v7/widget/av;I)V

    return-void
.end method

.method public c(Landroid/view/View;)V
    .locals 2

    invoke-static {p1}, Landroid/support/v7/widget/av;->e(Landroid/view/View;)Landroid/support/v7/widget/av$w;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-static {v0, v1}, Landroid/support/v7/widget/av$w;->a(Landroid/support/v7/widget/av$w;Landroid/support/v7/widget/av;)V

    :cond_0
    return-void
.end method

.method public d(Landroid/view/View;)V
    .locals 2

    invoke-static {p1}, Landroid/support/v7/widget/av;->e(Landroid/view/View;)Landroid/support/v7/widget/av$w;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/av$5;->a:Landroid/support/v7/widget/av;

    invoke-static {v0, v1}, Landroid/support/v7/widget/av$w;->b(Landroid/support/v7/widget/av$w;Landroid/support/v7/widget/av;)V

    :cond_0
    return-void
.end method
