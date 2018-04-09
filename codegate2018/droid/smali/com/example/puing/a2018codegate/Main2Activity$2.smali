.class Lcom/example/puing/a2018codegate/Main2Activity$2;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/example/puing/a2018codegate/Main2Activity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/example/puing/a2018codegate/Main2Activity;


# direct methods
.method constructor <init>(Lcom/example/puing/a2018codegate/Main2Activity;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/example/puing/a2018codegate/Main2Activity$2;->b:Lcom/example/puing/a2018codegate/Main2Activity;

    iput-object p2, p0, Lcom/example/puing/a2018codegate/Main2Activity$2;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    iget-object v0, p0, Lcom/example/puing/a2018codegate/Main2Activity$2;->b:Lcom/example/puing/a2018codegate/Main2Activity;

    iget-object v0, v0, Lcom/example/puing/a2018codegate/Main2Activity;->l:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, ""

    iget-object v1, p0, Lcom/example/puing/a2018codegate/Main2Activity$2;->a:Ljava/lang/String;

    invoke-static {v1}, Lcom/example/puing/a2018codegate/Main2Activity;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    const-class v3, Lcom/example/puing/a2018codegate/Main3Activity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v2, "id"

    iget-object v3, p0, Lcom/example/puing/a2018codegate/Main2Activity$2;->a:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const-string v2, "pass"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    iget-object v0, p0, Lcom/example/puing/a2018codegate/Main2Activity$2;->b:Lcom/example/puing/a2018codegate/Main2Activity;

    invoke-virtual {v0, v1}, Lcom/example/puing/a2018codegate/Main2Activity;->startActivity(Landroid/content/Intent;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/example/puing/a2018codegate/Main2Activity$2;->b:Lcom/example/puing/a2018codegate/Main2Activity;

    const v1, 0x7f080076

    invoke-virtual {v0, v1}, Lcom/example/puing/a2018codegate/Main2Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const-string v1, "wrong! try again"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
