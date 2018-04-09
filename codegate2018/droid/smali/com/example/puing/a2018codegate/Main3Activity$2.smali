.class Lcom/example/puing/a2018codegate/Main3Activity$2;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/example/puing/a2018codegate/Main3Activity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/example/puing/a2018codegate/Main3Activity;


# direct methods
.method constructor <init>(Lcom/example/puing/a2018codegate/Main3Activity;)V
    .locals 0

    iput-object p1, p0, Lcom/example/puing/a2018codegate/Main3Activity$2;->a:Lcom/example/puing/a2018codegate/Main3Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    iget-object v0, p0, Lcom/example/puing/a2018codegate/Main3Activity$2;->a:Lcom/example/puing/a2018codegate/Main3Activity;

    invoke-virtual {v0}, Lcom/example/puing/a2018codegate/Main3Activity;->k()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/example/puing/a2018codegate/Main3Activity$2;->a:Lcom/example/puing/a2018codegate/Main3Activity;

    iget-object v1, v1, Lcom/example/puing/a2018codegate/Main3Activity;->l:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/example/puing/a2018codegate/Main4Activity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iget-object v1, p0, Lcom/example/puing/a2018codegate/Main3Activity$2;->a:Lcom/example/puing/a2018codegate/Main3Activity;

    invoke-virtual {v1, v0}, Lcom/example/puing/a2018codegate/Main3Activity;->startActivity(Landroid/content/Intent;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/example/puing/a2018codegate/Main3Activity$2;->a:Lcom/example/puing/a2018codegate/Main3Activity;

    const v1, 0x7f080076

    invoke-virtual {v0, v1}, Lcom/example/puing/a2018codegate/Main3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const-string v1, "wrong! try again"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
